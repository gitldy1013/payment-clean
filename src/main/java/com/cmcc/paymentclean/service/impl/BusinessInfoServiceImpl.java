package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.config.SftpConfig;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.entity.BusinessInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;
import com.cmcc.paymentclean.entity.dto.response.BusinessInfoResp;
import com.cmcc.paymentclean.exception.bizException.BizException;
import com.cmcc.paymentclean.mapper.BusinessInfoMapper;
import com.cmcc.paymentclean.service.BusinessInfoService;
import com.cmcc.paymentclean.utils.ExcelUtils;
import com.cmcc.paymentclean.utils.SFTPUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.FileOutputStream;
import java.util.ArrayList;
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
        List<BusinessInfoResp> businessInfoResps = businessInfoMapper.qryBySubmitStatus("0");
        if (CollectionUtils.isEmpty(businessInfoResps)) {
            return resultBean;
        }
        List<String> stringList = new ArrayList<>();
        for (BusinessInfoResp businessInfoResp : businessInfoResps) {
            stringList.add(businessInfoResp.getBusinessInfoId());
        }

        //生成excel文件
        ExcelUtils excelUtils = new ExcelUtils();
        String fileName = sftpConfig.getQueryPcacMerchantRiskInfoFileNamePrefix() + System.currentTimeMillis() + CommonConst.SFTP_FILE_NAME_SUFFIX;
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

        SFTPUtils sftpUtils = new SFTPUtils();
        //上传文件
        try {
            sftpUtils.operateSFTP(sftpConfig.getUsername(), sftpConfig.getHost(), sftpConfig.getPort(), sftpConfig.getPassword(),
                    sftpConfig.getRemotePathUpload(), fileName, sftpConfig.getModDir(), fileName, SFTPUtils.OPERATE_UPLOAD);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sftpUtils.disconnect();
        }

        //更新状态为推送
        businessInfoMapper.updateSubmitStatus(stringList);
        return resultBean;
    }

}
