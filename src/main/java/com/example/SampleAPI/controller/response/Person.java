package com.example.SampleAPI.controller.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class Person {
    private String name;
    private int age;
    private String sex;
    private String job;

    private List<Person> family;

    public Person(){

    }

    public Person(String name, int age, String sex, String job) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.job = job;
    }
}
