package com.cmcc.paymentclean.controller;

import com.cmcc.paymentclean.utils.InnerCipherUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaolei
 * @date 2020-11-06 16:02
 */
@Controller
@RequestMapping(value = "/inner")
public class InnerCipherController {

    @ApiOperation(value = "内部加解密接口,true是身份证号", notes = "内部加解密接口,true是身份证号")
    @RequestMapping(value = "/decript",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String decript(boolean flag ,String message){
        String s=null;
        if (flag){

            s = InnerCipherUtils.decryptUserData(message);
        }else {
             s =   InnerCipherUtils.decryptBankData(message);
        }
        return "解密结果是："+s;
    }
    @ApiOperation(value = "内部加解密接口,true是身份证号", notes = "内部加解密接口,true是身份证号")
    @RequestMapping(value = "/encript",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String encript(boolean flag,String message){
        String s=null;
        if (flag){

             s = InnerCipherUtils.encryptUserData(message);
        }else {
           s= InnerCipherUtils.encryptBankData(message);
        }
        return "加密结果是："+s;
    }
}
