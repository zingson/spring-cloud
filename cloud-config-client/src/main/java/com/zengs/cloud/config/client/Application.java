package com.zengs.cloud.config.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
//@SpringCloudApplication
@SpringBootApplication
public class Application {

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        Map<String,Object> defaultMap = new HashMap<>();

        // 启动没读取uri配置信息?????
        defaultMap.put("spring.cloud.config.uri","http://127.0.0.1:8080/");
        app.setDefaultProperties(defaultMap);
        app.run(args);


        //SpringApplication.run(Application.class, args);
    }


    @RequestMapping("/from")
    public String from(){
        System.out.println(environment.getProperty("spring.cloud.config.uri"));
        return "-----"+environment.getProperty("from");
    }

}
