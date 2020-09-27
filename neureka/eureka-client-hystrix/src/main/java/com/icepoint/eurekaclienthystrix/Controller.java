package com.icepoint.eurekaclienthystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hystrix")
public class Controller {

    @Autowired
    private RestTemplateConfig ribbonConfig;

    @PostMapping(value = "/testHystrix")
    @HystrixCommand(fallbackMethod = "fallBack")
    public String testHystrix(){
        ResponseEntity<String> stringResponseEntity = ribbonConfig.restTemplate().postForEntity("http://eureka-client/ribbon/helloHystrix", "good", String.class);
        return stringResponseEntity.getBody();
    }

    //此熔断方法的入参和出参，必须和原方法一致
    public String fallBack(){
        return "调用失败，开始熔断";
    }

}
