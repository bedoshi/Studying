package com.example.SampleAPI.controller.rest;

import com.example.SampleAPI.controller.response.Person;
import org.springframework.web.bind.annotation.*;

/**
 * This controller is sample code for getting request parameter.
 */
@RestController
@RequestMapping("/api/param")
public class SampleParamAPIController {

    /**
     * Getting parameter as age and return Person json.
     * And Using PathVariable.
     * @return person obj.
     */
    @GetMapping("/{age}")
    public Person personWithAge(@PathVariable("age") int personAge) {
        Person person = new Person();
        person.setAge(personAge);
        return person;
    }

    /**
     * Getting parameter as age and return Person json.
     * And Using PathVariable.
     * @param personName person name from url
     * @param personAge person age from url
     * @return person obj.
     */
    @RequestMapping("/{age}/{name}")
    public Person personWithNameAndAge(
            @PathVariable("name") String personName,
            @PathVariable("age") int personAge) {
        Person person = new Person();
        person.setName(personName);
        person.setAge(personAge);
        return person;
    }

    /**
     * Return person object with using RequestParam.
     * @param name person name
     * @param age person age
     * @return person object.
     */
    @GetMapping("")
    public Person personNameFromParam (
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "age", required = false) int age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);

        return person;
    }
}
