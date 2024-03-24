package com.xiaolanhe;

import org.junit.Test;

/**
 *@author: xiaolanhe
 *@createDate: 2024/3/24 23:08
 */
public class TestApi {
    @Test
    public void test_LoginSsoDecorator() {
        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator();
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验：" + request + (success ? " 放行" : " 拦截"));
    }

}
