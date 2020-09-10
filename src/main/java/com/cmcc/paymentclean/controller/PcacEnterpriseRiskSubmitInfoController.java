package com.cmcc.paymentclean.controller;


import com.cmcc.paymentclean.entity.PcacEnterpriseRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.service.PcacEnterpriseRiskSubmitInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 协会企业风险信息上报表  前端控制器
 * </p>
 *
 * @author cmcc
 * @since 2020-09-10
 * @version v1.0
 */
@RestController
@RequestMapping("/paymentclean/api/v1/pcac-enterprise-risk-submit-info")
public class PcacEnterpriseRiskSubmitInfoController {

    @Autowired
    private PcacEnterpriseRiskSubmitInfoService pcacEnterpriseRiskSubmitInfoService;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(pcacEnterpriseRiskSubmitInfoService.listPcacEnterpriseRiskSubmitInfosByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(pcacEnterpriseRiskSubmitInfoService.getPcacEnterpriseRiskSubmitInfoById(id));
    }

    /**
    * 新增
    */
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody PcacEnterpriseRiskSubmitInfo pcacEnterpriseRiskSubmitInfo) {
        return new ResultBean<>(pcacEnterpriseRiskSubmitInfoService.insertPcacEnterpriseRiskSubmitInfo(pcacEnterpriseRiskSubmitInfo));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(pcacEnterpriseRiskSubmitInfoService.deletePcacEnterpriseRiskSubmitInfoById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody PcacEnterpriseRiskSubmitInfo pcacEnterpriseRiskSubmitInfo) {
        return new ResultBean<>(pcacEnterpriseRiskSubmitInfoService.updatePcacEnterpriseRiskSubmitInfo(pcacEnterpriseRiskSubmitInfo));
    }
}
