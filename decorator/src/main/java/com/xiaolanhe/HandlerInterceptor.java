package com.xiaolanhe;

/**
 *@author: xiaolanhe
 *@createDate: 2024/3/24 23:00
 */
public interface HandlerInterceptor {
    boolean preHandle(String request, String response, Object handler);
}
