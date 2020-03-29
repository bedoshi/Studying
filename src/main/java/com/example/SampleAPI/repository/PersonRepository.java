package com.example.SampleAPI.repository;

import com.example.SampleAPI.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository {
    int insertPerson(Person person);
}
