package com.example.SampleAPI.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
