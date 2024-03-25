package com.xiaolanhe.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *@author: xiaolanhe
 *@createDate: 2024/3/25 23:38
 */

// 配置类注解定义

@ConfigurationProperties("itstack.door")
public class StarterServiceProperties {
    private String userStr;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }
}
