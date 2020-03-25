package com.example.SampleAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class SampleAPI {

    @RequestMapping(value = "/index")
    public String index() {
        return "hello world";
    }

}
