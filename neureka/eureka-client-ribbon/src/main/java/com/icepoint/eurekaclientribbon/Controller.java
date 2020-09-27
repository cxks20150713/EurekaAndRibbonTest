package com.icepoint.eurekaclientribbon;

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
    private RibbonConfig ribbonConfig;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @PostMapping(value = "/testRibbon")
    public String helloRibbon(){
        ResponseEntity<String> stringResponseEntity = ribbonConfig.restTemplate().postForEntity("http://eureka-client/ribbon/helloRibbon", "good", String.class);
        return stringResponseEntity.getBody();
    }

    @PostMapping(value = "/chooseRibbon")
    public String chooseRibbon(){
        ServiceInstance choose = loadBalancerClient.choose("eureka-client");
        int port = choose.getPort();
        return "ribbon获取到的端口为：" + port;
    }



}
