package com.zengs.cloud.hystrix;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
@SpringBootApplication(scanBasePackages = {"com.zengs"})
public class HystrixApplication2 {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixApplication2.class).web(WebApplicationType.SERVLET).run(args);
    }

}
