package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.LoginResult;

/**
 * 登录清算协会获取UserToken
 *
 * @author zhaolei
 * @since 2020-09-16
 */
public interface LoginPcacService {

  LoginResult login();

  LoginResult logout();
}
