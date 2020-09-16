package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.config.SftpConfig;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.entity.BusinessInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resq.*;
import com.cmcc.paymentclean.entity.dto.response.BusinessInfoResp;
import com.cmcc.paymentclean.exception.bizException.BizException;
import com.cmcc.paymentclean.mapper.BusinessInfoMapper;
import com.cmcc.paymentclean.service.BusinessInfoService;
import com.cmcc.paymentclean.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 企业商户信息表  服务实现类
 * </p>
 *
 * @author cmcc
 * @since 2020-09-15
 */
@Slf4j
@Service
public class BusinessInfoServiceImpl extends ServiceImpl<BusinessInfoMapper, BusinessInfo> implements BusinessInfoService {

    @Autowired
    private SftpConfig sftpConfig;

    @Autowired
    private PcacConfig pcacConfig;

    @Override
    public Page<BusinessInfo> listBusinessInfosByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询businessInfo: page = {} pageSize = {} factor = {}", page, pageSize, factor);
        QueryWrapper<BusinessInfo> queryWrapper = new QueryWrapper<BusinessInfo>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<BusinessInfo> result = super.page(new Page<BusinessInfo>(page, pageSize), queryWrapper);
        result.setTotal(result.getRecords().size());
        log.info("分页查询businessInfo完毕: 结果数 = {} ", result.getRecords().size());
        return result;
    }

    @Override
    public BusinessInfo getBusinessInfoById(int id) {
        log.info("正在查询businessInfo中id为{}的数据", id);
        BusinessInfo businessInfo = super.getById(id);
        log.info("查询id为{}的businessInfo{}", id, (null == businessInfo ? "无结果" : "成功"));
        return businessInfo;
    }

    @Override
    public int insertBusinessInfo(BusinessInfo businessInfo) {
        log.info("正在插入businessInfo");
        if (super.save(businessInfo)) {
            log.info("插入businessInfo成功,id为{}", businessInfo.getBusinessInfoId());
            return businessInfo.getBusinessInfoId();
        } else {
            log.error("插入businessInfo失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteBusinessInfoById(int id) {
        log.info("正在删除id为{}的businessInfo", id);
        if (super.removeById(id)) {
            log.info("删除id为{}的businessInfo成功", id);
            return id;
        } else {
            log.error("删除id为{}的businessInfo失败", id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateBusinessInfo(BusinessInfo businessInfo) {
        log.info("正在更新id为{}的businessInfo", businessInfo.getBusinessInfoId());
        if (super.updateById(businessInfo)) {
            log.info("更新d为{}的businessInfo成功", businessInfo.getBusinessInfoId());
            return businessInfo.getBusinessInfoId();
        } else {
            log.error("更新id为{}的businessInfo失败", businessInfo.getBusinessInfoId());
            throw new BizException("更新失败[id=" + businessInfo.getBusinessInfoId() + "]");
        }
    }

    @Autowired
    private BusinessInfoMapper businessInfoMapper;

    @Override
    public ResultBean<Body> exportExcel() {
        ResultBean resultBean = new ResultBean();
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        //查出未推送数据
        List<BusinessInfoResp> businessInfoResps = businessInfoMapper.qryByPushStatus("0");
        if (CollectionUtils.isEmpty(businessInfoResps)) {
            return resultBean;
        }
        List<String> stringList = new ArrayList<>();
        for (BusinessInfoResp businessInfoResp : businessInfoResps) {
            stringList.add(businessInfoResp.getBusinessInfoId());
        }

        //生成excel文件
        ExcelUtils excelUtils = new ExcelUtils();
        String fileName = sftpConfig.getBusinessInfoFileNamePrefix() + System.currentTimeMillis() + CommonConst.SFTP_FILE_NAME_SUFFIX;
        try {
            //文件名
            SXSSFWorkbook sxssfWorkbook = excelUtils.exportExcel(businessInfoResps, BusinessInfoResp.class);
            FileOutputStream fos = new FileOutputStream(sftpConfig.getModDir() + fileName);
            sxssfWorkbook.write(fos);
            // dispose of temporary files backing this workbook on disk -> 处理SXSSFWorkbook导出excel时，产生的临时文件
            sxssfWorkbook.dispose();
            fos.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        //上传文件
        SFTPUtils.operateSFTP(sftpConfig.getUsername(), sftpConfig.getHost(), sftpConfig.getPort(), sftpConfig.getPassword(),
                sftpConfig.getRemotePathUpload(), fileName, sftpConfig.getModDir(), fileName, SFTPUtils.OPERATE_UPLOAD);
        //更新状态为推送
        businessInfoMapper.updatePushStatus(stringList);
        return resultBean;
    }

    @Override
    public void queryBusinessInfoAndPushPcac() {
        //获取未上报的数据
        QueryWrapper<BusinessInfo> queryWrapper = new QueryWrapper<BusinessInfo>().like("submit_status", "0");
        List<BusinessInfo> businessInfos = businessInfoMapper.selectList(queryWrapper);
        if (businessInfos.size() == 0) {
            log.info("当前没有可上报的企业商户信息");
            return;
        }
        Document document = getDocument(businessInfos);
        //报文转换
        String xml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.info("获取到的xml数据:{}", xml);
        if (StringUtils.isEmpty(xml)) {
            log.info("xml报文转换失败");
            return;
        }
        //校验xml报文  企业商户信息上报请求
        boolean validate = ValidateUtils.validateXMLByXSD(xml, "pcac.ries.025");
        if (!validate) {
            log.info("XML校验失败");
            return;
        }
        pushToPcac(businessInfos, xml);
    }

    private void pushToPcac(List<BusinessInfo> businessInfos, String xml) {
        //上报数据
        String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
        log.info("url:{}", pcacConfig.getUrl());
            /*String post = "<Body>\n" +
                    "    <RespInfo>\n" +
                    "        <ResultStatus>已上报</ResultStatus>\n" +
                    "        <ResultCode>01</ResultCode>\n" +
                    "    </RespInfo>\n" +
                    "</Body>";*/
        com.cmcc.paymentclean.entity.dto.pcac.resp.Body resBody = (com.cmcc.paymentclean.entity.dto.pcac.resp.Body) XmlJsonUtils.convertXmlStrToObject(com.cmcc.paymentclean.entity.dto.pcac.resp.Body.class, post);
        log.info("协会返回数据对象:{}", resBody);
        for (BusinessInfo pcacMerchantRiskSubmitInfo : businessInfos) {
            UpdateWrapper<BusinessInfo> updateWrapper = new UpdateWrapper<BusinessInfo>();
            updateWrapper.eq("submit_status","1");
            updateWrapper.eq("rep_date",new Date());
            businessInfoMapper.update(pcacMerchantRiskSubmitInfo, updateWrapper);
        }
    }

    private Document getDocument(List<BusinessInfo> businessInfos) {
        //拼装报文
        Document document = new Document();
        byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
        //设置报文头
        Request request = XmlJsonUtils.getRequest(symmetricKeyEncoded, document, pcacConfig);
        //设置报文体
        com.cmcc.paymentclean.entity.dto.pcac.resq.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.Body();
        PcacList pcacList = new PcacList();
        for (int i = 0; i < businessInfos.size(); i++) {
            pcacList.setCount(businessInfos.size());
            ArrayList<BaseInfo> baseInfos = new ArrayList<BaseInfo>();
            BaseInfo baseInfo = new BaseInfo();
            BusinessInfo businessInfo = businessInfos.get(i);
            BeanUtils.copyProperties(businessInfo, baseInfo);
            baseInfo.setRepDate(DateUtils.formatTime(new Date(System.currentTimeMillis()), null));
            baseInfo.setBankNo(CFCACipherUtils.encrypt(symmetricKeyEncoded, businessInfo.getBankNo()));

            //解密风控加密协会 商户上报：
            //商户名称
            baseInfo.setRegName(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getRegName()));
            //商户简称
            baseInfo.setCusName(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getCusName()));
            //商户代码
            baseInfo.setCusCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getCusCode()));
            //法人证件号码
            baseInfo.setDocCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getDocCode()));
            //法定代表人姓名/负责人姓名
            baseInfo.setLegDocName(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getLegDocName()));
            //法定代表人（负责人）证件号码
            baseInfo.setLegDocCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getLegDocCode()));
            //外包服务机构法定代表人证件号码"
            baseInfo.setOutServiceLegCardCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getOutServiceLegCardCode()));
            //外包服务机构法人证件号码
            baseInfo.setOutServiceCardCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getOutServiceCardCode()));
            //商户联系人
            baseInfo.setContName(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getContName()));
            //商户联系电话
            baseInfo.setContPhone(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getContPhone()));
            //网址
            baseInfo.setUrl(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getUrl()));
            //服务器 ip
            baseInfo.setServerIp(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getServerIp()));
            //ICP 备案编号
            baseInfo.setIcp(CFCACipherUtils.encrypt(symmetricKeyEncoded, businessInfo.getRegName()));
            baseInfo.setDocCode(CFCACipherUtils.getInnerToCFCA(businessInfo.getDocType(), businessInfo.getDocCode(), symmetricKeyEncoded));
            baseInfos.add(baseInfo);
            pcacList.setBaseInfo(baseInfos);
        }
        body.setPcacList(pcacList);
        request.setBody(body);
        document.setRequest(request);
        return document;
    }
}
