package com.xiaolanhe;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/** mq消息体适配类
 *@author: xiaolanhe
 *@createDate: 2024/3/24 21:40
 */
public class MQAdapter {

    public static UnifyMessageBody filter (String strJson, Map<String, String> relation) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return filter(JSON.parseObject(strJson, Map.class), relation);
    }

    public static UnifyMessageBody filter (Map obj, Map<String, String> relation) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        UnifyMessageBody message = new UnifyMessageBody();
        // 把不同类型的mq消息的各种属性，映射成统一的消息体所需要的属性
        for(String key : relation.keySet()){
            Object value = obj.get(relation.get(key));
            UnifyMessageBody.class.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class).invoke(message, value.toString());
        }
        return message;
    }

}
