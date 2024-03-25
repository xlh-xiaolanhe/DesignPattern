package com.xiaolanhe.aop;

import com.alibaba.fastjson.JSON;
import com.xiaolanhe.annotation.DonDoor;
import com.xiaolanhe.config.StarterService;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**  切面定义
 *@author: xiaolanhe
 *@createDate: 2024/3/25 23:34
 */

@Aspect
@Component
public class DoJoinPoint {

    private Logger logger = LoggerFactory.getLogger(DoJoinPoint.class);

    @Autowired
    private StarterService starterService;


    @Pointcut("@annotation(com.xiaolanhe.annotation.DonDoor)")
    public void aopPoint(){

    }

    @Around("aopPoint()")
    public Object doRouter(ProceedingJoinPoint jp) throws Throwable {
        // 获取内容
        Method method = getMethod(jp);
        DonDoor door = method.getAnnotation(DonDoor.class);

        // 获取字段值
        String keyValue = getFiledValue(door.key(), jp.getArgs());
        logger.info("itstack door handler method：{} value：{}", method.getName(), keyValue);

        if(StringUtils.isEmpty(keyValue)){
            return jp.proceed();
        }

        // 获取配置内容
        String[] split = starterService.split(",");
        for(String str : split){
            if(keyValue.equals(str)){
                return jp.proceed();
            }
        }

        // 拦截
        return returnObject(door, method);
    }

    /**
     * desciption 返回拦截后的转换对象
      * @param door
     * @param method
    */
    private Object returnObject(DonDoor door, Method method) throws InstantiationException, IllegalAccessException {
        Class<?> returnType = method.getReturnType();
        String returnJson = door.returnJson();
        if ("".equals(returnJson)) {
            return returnType.newInstance();
        }
        return JSON.parseObject(returnJson, returnType);
    }

    /**
     * desciption 获取方法名
      * @param jp
     * @return java.lang.reflect.Method
    */
    private Method getMethod(ProceedingJoinPoint jp) throws NoSuchMethodException {
        Signature signature = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        return getClass(jp).getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    }

    private Class<? extends Object> getClass(JoinPoint jp){
        return jp.getTarget().getClass();
    }


    /**
     * desciption  根据具体属性名获取属性值
      * @param filed
     * @param args
     * @return java.lang.String
    */
    private String getFiledValue(String filed, Object[] args){
        String filedValue = null;
        try{
            for(Object arg : args){
                if(StringUtils.isEmpty(filedValue)){
                    filedValue = BeanUtils.getProperty(arg, filed);
                }else {
                    break;
                }
            }
        }catch (Exception e) {
            if(args.length == 1){
                return args[0].toString();
            }

        }
        return filedValue;
    }

}
