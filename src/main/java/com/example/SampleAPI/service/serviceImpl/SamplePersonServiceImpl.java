package com.example.SampleAPI.service.serviceImpl;

import com.example.SampleAPI.controller.response.Person;
import com.example.SampleAPI.exception.PersonUnder18Exception;
import com.example.SampleAPI.repository.PersonRepository;
import com.example.SampleAPI.service.SamplePersonService;
import org.springframework.beans.factory.annotation.Autowired;

public class SamplePersonServiceImpl implements SamplePersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public Person registerPersonData(String name, Integer age){

        Person person = new Person();
        person.setName(name);
        person.setAge(age);

        if (!isPersonOver18(person)) {
            throw new PersonUnder18Exception("this person is under 18 years old.");
        }

        personRepository.insertPerson(person);

        return person;
    }

    /**
     * Checking parameter person is over 18years old.
     * @param person person
     * @return true : person is over 18 years old.
     */
    private boolean isPersonOver18(Person person){
        return person.getAge() >= 18;
    }

}
