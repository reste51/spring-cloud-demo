package com.unimas.study.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 将配置文件 注入到 实体类中的 样式
 * @ClassName MysqlConfig
 * @Description TODO
 * @Author 50204
 * @Date 2020/3/19 23:10
 * @Version 1.0
 **/
@Data
@Component
@ConfigurationProperties(prefix = "add-conf.mysql")
public class MysqlConfig {
    private  String host;
    private  String port;
    private  String username;
    private  String password;

    @Override
    public String toString() {
        return "MysqlConfig{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
