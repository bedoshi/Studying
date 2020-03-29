package com.example.SampleAPI.repository;

import com.example.SampleAPI.controller.response.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository {
    int insertPerson(Person person);
}
