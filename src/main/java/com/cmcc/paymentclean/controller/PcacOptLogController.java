package com.cmcc.paymentclean.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.service.PcacOptLogService;
import com.cmcc.paymentclean.entity.PcacOptLog;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 操作日志表  前端控制器
 * </p>
 *
 * @author cmcc
 * @since 2020-09-07
 * @version v1.0
 */
@RestController
@RequestMapping("/paymentclean/api/v1/pcac-opt-log")
public class PcacOptLogController {

    @Autowired
    private PcacOptLogService pcacOptLogService;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(pcacOptLogService.listPcacOptLogsByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(pcacOptLogService.getPcacOptLogById(id));
    }

    /**
    * 新增
    */
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody PcacOptLog pcacOptLog) {
        return new ResultBean<>(pcacOptLogService.insertPcacOptLog(pcacOptLog));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(pcacOptLogService.deletePcacOptLogById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody PcacOptLog pcacOptLog) {
        return new ResultBean<>(pcacOptLogService.updatePcacOptLog(pcacOptLog));
    }
}
