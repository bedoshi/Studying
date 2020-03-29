package com.example.SampleAPI.repository;

import com.example.SampleAPI.model.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PersonRepository {
    Person selectPersonWithName(String name);
    int insertPerson(Person person);
}
