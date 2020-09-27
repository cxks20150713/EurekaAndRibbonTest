package com.icepoint.eurekaclient2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ribbon")
public class Controller {

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/helloRibbon")
    public String helloRibbon() {
        return "hello Ribbon" + port;
    }

    @PostMapping(value = "/helloHystrix")
    public String helloHystrix() {
        return "hello hystrix" + port;
    }

}
