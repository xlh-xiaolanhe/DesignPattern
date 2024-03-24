package com.xiaolanhe;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *@author: xiaolanhe
 *@createDate: 2024/3/24 23:04
 */

// 以往使用的SSO是一个组件化通用的服务，不能在里面添加需要的用户访问验证功能。需要扩充原有的单点登录服务
public class LoginSsoDecorator extends ssoInterceptor{

    private static Map<String, String> authMap = new ConcurrentHashMap<String, String>();

    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        boolean success = super.preHandle(request, response, handler);

        if (!success) return false;

        String userId = request.substring(9);
        String method = authMap.get(userId);

        // 模拟方法校验
        return "queryUserInfo".equals(method);
    }
}
