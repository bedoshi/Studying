package com.example.SampleAPI.repository;

import com.example.SampleAPI.model.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PersonRepository {
    List<Person> selectPersonWithName(String name);
    int insertPerson(Person person);
}
