package com.xiaolanhe;/**
 * @Package com.xiaolanhe
 * @author xiaolanhe
 * @date 2024/3/24 23:20
 * @version V1.0
 */

import org.junit.Test;

/**
 *@author: xiaolanhe
 *@createDate: 2024/3/24 23:20
 */
public class TestApi {
    @Test
    public void test_LoginSsoDecorator() {
        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator(new ssoInterceptor());
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验：" + request + (success ? " 放行" : " 拦截"));
    }

}
