package com.xiaolanhe;

import org.junit.Test;

/**
 *@author: xiaolanhe
 *@createDate: 2024/3/24 23:02
 */
public class TestApi {
    @Test
    public void test_sso() {
        ssoInterceptor ssoInterceptor = new ssoInterceptor();
        String request = "1successhuahua";
        boolean success = ssoInterceptor.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验：" + request +(success ? " 放行" : " 拦截"));
    }
}
