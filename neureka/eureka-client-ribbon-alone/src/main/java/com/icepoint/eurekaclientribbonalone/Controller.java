package com.icepoint.eurekaclientribbonalone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ribbon")
public class Controller {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @PostMapping(value = "/chooseRibbon")
    public String chooseRibbon(){
        ServiceInstance choose = loadBalancerClient.choose("servers");
        String host = choose.getHost();
        return "ribbon获取到的ip为：" + host;
    }



}
