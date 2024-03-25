package com.xiaolanhe.config;

/**
 *@author: xiaolanhe
 *@createDate: 2024/3/25 23:36
 */

// 配置服务类
public class StarterService {

    private String userStr;

    public StarterService(String userStr) {
        this.userStr = userStr;
    }

    public String[] split(String separatorChar){
        return userStr.split(separatorChar);
    }
}
