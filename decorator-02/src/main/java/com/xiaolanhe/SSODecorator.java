package com.xiaolanhe;

/**
 *@author: xiaolanhe
 *@createDate: 2024/3/24 23:12
 */

/**
 在装饰类中有两个重点的地方是；1)继承了处理接口、2)提供了构造函数、3)覆盖了方法preHandle。
 以上三个点是装饰器模式的核心处理部分，这样可以踢掉对子类继承的方式实现逻辑功能扩展。
*/

// 抽象类装饰角色
public abstract class SSODecorator implements HandlerInterceptor{

    private HandlerInterceptor handlerInterceptor;

    public SSODecorator(){

    }

    public SSODecorator(HandlerInterceptor handlerInterceptor){
        this.handlerInterceptor = handlerInterceptor;
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        return handlerInterceptor.preHandle(request, response, handler);
    }
}
