package com.zengs.cloud.ribbon.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringCloudApplication
public class RibbonApplication {

    final Logger log = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class,args);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "/hello-02"+System.currentTimeMillis();
    }

}
