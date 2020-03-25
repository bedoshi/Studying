package com.example.SampleAPI.controller;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class SampleAPIController {

    @RequestMapping(value = "/index")
    public String index() {
        return "hello world";
    }

    @RequestMapping(value = "/person")
    public String returnPersonJson() {
        return "{\"person\" : {\"name\" : \"yamada taro\", \"age\" : 20 }}";
    }

    @RequestMapping(value = "/person_json")
    public String returnPersonJson2() {
        Map<String,String> param = new HashMap<>();
        param.put("年齢", "20");
        param.put("性別", "男");

        JSONObject jsonObj = new JSONObject(param);

        return jsonObj.toString();
    }

}
