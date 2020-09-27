package com.icepoint.eurekaclient;

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
    public String helloRibbon(String ipPort) {
        return "hello Ribbon" + port;
    }

}
