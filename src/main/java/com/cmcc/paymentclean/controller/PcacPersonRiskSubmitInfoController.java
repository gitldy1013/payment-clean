package com.cmcc.paymentclean.controller;


import com.cmcc.paymentclean.entity.PcacPersonRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.service.PcacPersonRiskSubmitInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 协会个人风险信息上报表  前端控制器
 * </p>
 *
 * @author zhaolei
 * @since 2020-09-13
 * @version v1.0
 */
@RestController
@RequestMapping("/paymentclean/api/v1/pcac-person-risk-submit-info")
public class PcacPersonRiskSubmitInfoController {

    @Autowired
    private PcacPersonRiskSubmitInfoService pcacPersonRiskSubmitInfoService;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(pcacPersonRiskSubmitInfoService.listPcacPersonRiskSubmitInfosByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(pcacPersonRiskSubmitInfoService.getPcacPersonRiskSubmitInfoById(id));
    }

    /**
    * 新增
    */
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody PcacPersonRiskSubmitInfo pcacPersonRiskSubmitInfo) {
        return new ResultBean<>(pcacPersonRiskSubmitInfoService.insertPcacPersonRiskSubmitInfo(pcacPersonRiskSubmitInfo));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(pcacPersonRiskSubmitInfoService.deletePcacPersonRiskSubmitInfoById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody PcacPersonRiskSubmitInfo pcacPersonRiskSubmitInfo) {
        return new ResultBean<>(pcacPersonRiskSubmitInfoService.updatePcacPersonRiskSubmitInfo(pcacPersonRiskSubmitInfo));
    }
}
