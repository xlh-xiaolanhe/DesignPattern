package com.xiaolanhe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@author: xiaolanhe
 *@createDate: 2024/3/25 23:42
 */

// 自定义配置类信息获取

@Configuration
//在类路径中存在 StarterService 类时才会加载这个配置类。如果 StarterService 类不存在于类路径中，则该配置类将被忽略。
@ConditionalOnClass(StarterService.class)
// 启用了对 StarterServiceProperties 类的配置绑定。它告诉 Spring Boot 要扫描指定的类，并将其注册为一个可用的 Bean。
@EnableConfigurationProperties(StarterServiceProperties.class)
public class StarterAutoConfigure {

    @Autowired
    private StarterServiceProperties properties;

    @Bean
    // 如果容器中不存在 StarterService 类型的 Bean，才会创建 starterService 方法所定义的 Bean。
    @ConditionalOnMissingBean
    //指定了当名为 itstack.door.enabled 的属性值为 true 时才会创建这个 Bean。prefix 参数指定了属性的前缀，value 参数指定了属性的名称，havingValue 参数指定了属性的期望值。
    @ConditionalOnProperty(prefix = "itstack.door", value = "enabled", havingValue = "true")
    StarterService starterService(){
        return new StarterService(properties.getUserStr());
    }
}
