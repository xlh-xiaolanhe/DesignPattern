package com.xiaolnhe;

import com.alibaba.fastjson.JSON;
import com.xiaolanhe.MQAdapter;
import com.xiaolanhe.OrderAdapterService;
import com.xiaolanhe.UnifyMessageBody;
import com.xiaolanhe.mq.create_account;
import com.xiaolanhe.service.InsideOrderServiceImpl;
import com.xiaolanhe.service.PopOrderAdapterServiceImpl;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 *@author: xiaolanhe
 *@createDate: 2024/3/24 21:59
 */
public class TestApi {

    @Test
    public void test_MQAdapter() throws ParseException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = s.parse("2020-06-01 23:20:16");

        create_account account = new create_account();
        account.setNumber("100001");
        account.setAddress("河北省.廊坊市.广阳区.大学里职业技术学院");
        account.setAccountDate(date);
        account.setDesc("在校开户");

        HashMap<String, String> relationMap = new HashMap<>();
        relationMap.put("userId", "number");
        relationMap.put("bizId", "number");
        relationMap.put("bizTime", "accountDate");
        relationMap.put("desc", "desc");

        UnifyMessageBody messageOne = MQAdapter.filter(account.toString(), relationMap);
        System.out.println("适配前：" + account.toString());
        System.out.println("适配后： " + JSON.toJSONString(messageOne));
    }

    @Test
    public void test_ifAdapter()
    {
        OrderAdapterService popOrderAdapterService = new PopOrderAdapterServiceImpl();
        System.out.println("判断首单，接口适配(POP)：" + popOrderAdapterService.isFirst("100001"));

        OrderAdapterService insideOrderService = new InsideOrderServiceImpl();
        System.out.println("判断首单，接口适配(自营)：" + insideOrderService.isFirst("100001"));
    }
}
