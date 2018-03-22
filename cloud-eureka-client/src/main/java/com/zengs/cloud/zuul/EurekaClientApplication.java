package com.zengs.cloud.zuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableEurekaServer
@SpringCloudApplication
public class EurekaClientApplication {

    final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class,args);
    }

    @RequestMapping("/hello")
    public String index(){
        List<String> serviceIds = client.getServices();
        for (String serviceId : serviceIds) {
            List<ServiceInstance> instances = client.getInstances(serviceId);
            for (ServiceInstance instance : instances) {
                log.info("/hello,host:{} ,service_id:{}",instance.getHost(),instance.getServiceId());
            }
        }
        return "Hello World";
    }

}
