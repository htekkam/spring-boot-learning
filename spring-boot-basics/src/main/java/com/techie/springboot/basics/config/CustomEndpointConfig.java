package com.techie.springboot.basics.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "customInfo")
public class CustomEndpointConfig {

    @Value("${custom.info}")
    private String customEndpoint;

    @ReadOperation
    public String customInfo(){
        return customEndpoint;
    }


}
