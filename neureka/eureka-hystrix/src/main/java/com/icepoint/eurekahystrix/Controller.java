package com.icepoint.eurekahystrix;

import com.icepoint.eurekahystrix.alone.HystrixTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hystrix")
public class Controller {

    @Value("${server.port}")
    private String port;


    @PostMapping(value = "/helloHystrix")
    public String helloRibbon(){
        String ceshi = (String) new HystrixTest("ceshi").execute();
        return ceshi;
    }

}
