package com.cmcc.paymentclean.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.service.PcacRiskInfoService;
import com.cmcc.paymentclean.entity.PcacRiskInfo;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商户黑名单提示信息表 前端控制器
 * </p>
 *
 * @author cmcc
 * @since 2020-09-07
 * @version v1.0
 */
@RestController
@RequestMapping("/paymentclean/api/v1/pcac-risk-info")
public class PcacRiskInfoController {

    @Autowired
    private PcacRiskInfoService pcacRiskInfoService;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(pcacRiskInfoService.listPcacRiskInfosByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(pcacRiskInfoService.getPcacRiskInfoById(id));
    }

    /**
    * 新增
    */
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody PcacRiskInfo pcacRiskInfo) {
        return new ResultBean<>(pcacRiskInfoService.insertPcacRiskInfo(pcacRiskInfo));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(pcacRiskInfoService.deletePcacRiskInfoById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody PcacRiskInfo pcacRiskInfo) {
        return new ResultBean<>(pcacRiskInfoService.updatePcacRiskInfo(pcacRiskInfo));
    }
}
