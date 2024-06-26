package com.xiaolnhe.web;

import com.xiaolanhe.annotation.DonDoor;
import com.xiaolnhe.domain.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *@author: xiaolanhe
 *@createDate: 2024/3/25 23:13
 */

// 后续就需要在这里扩展白名单，只有指定用户才可以查询，其他用户不能查询。
@RestController
public class HelloWorldController {

    @Value("${server.port}")
    private int port;

    @DonDoor(key = "userId", returnJson = "{\"code\":\"1111\",\"info\":\"非白名单可访问用户拦截！\"}")
    @RequestMapping(path = "/api/queryUserInfo", method = RequestMethod.GET)
    public UserInfo queryUserInfo(@RequestParam String userId) {

        /*// 做白名单拦截
        List<String> userList = new ArrayList<String>();
        userList.add("1001");
        userList.add("aaaa");
        userList.add("ccc");
        if (!userList.contains(userId)) {
            return new UserInfo("1111", "非白名单可访问用户拦截！");
        }*/

        return new UserInfo("虫虫:" + userId, 19, "天津市南开区旮旯胡同100号");
    }
}
