package com.example.SampleAPI.controller.rest;

import com.example.SampleAPI.controller.response.Person;
import com.example.SampleAPI.service.SamplePersonService;
import com.example.SampleAPI.service.serviceImpl.SamplePersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class SampleServiceCallController {

    @Autowired
    SamplePersonService samplePersonService;

    @RequestMapping("/person")
    public Person registerPerson(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age
    ) {

        return samplePersonService.registerPersonData(name, age);
    }
}
