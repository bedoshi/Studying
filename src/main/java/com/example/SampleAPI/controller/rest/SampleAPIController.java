package com.example.SampleAPI.controller.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.SampleAPI.controller.response.Person;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller class is sample how RestController returns response.
 */
@RestController
@RequestMapping(value = "/api/static")
public class SampleAPIController {

    @RequestMapping(value = "/index")
    public String index() {
        return "hello world";
    }

    @RequestMapping(value = "/person")
    public String returnPersonJson() {
        return "{\"person\":{\"name\":\"yamada taro\",\"age\":20}}";
    }

    @RequestMapping(value = "/person_json")
    public String returnPersonJson2() {
        Map<String,String> param = new HashMap<>();
        param.put("age", "20");
        param.put("sex", "man");

        JSONObject jsonObj = new JSONObject(param);

        return jsonObj.toString();
    }

    @RequestMapping(value = "/person_obj")
    public Person returnPersonObj() {

        Person person = new Person();
        person.setAge(10);
        person.setName("yamada taro");
        person.setJob("front-end engineer");
        person.setSex("male");

        Person father = new Person("yamada jiro", 40, "male", "server side engineer");
        List<Person> fathersFamily = new ArrayList<>();
        father.setFamily(fathersFamily);
        List<Person> family = new ArrayList<>();
        family.add(father);

        person.setFamily(family);
        return person;
    }

}
