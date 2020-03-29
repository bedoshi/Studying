package com.example.SampleAPI.service;

import com.example.SampleAPI.controller.response.Person;
import org.springframework.stereotype.Service;

/**
 * This is sample code for service components.
 */
@Service
public interface SamplePersonService {

    /**
     * Registering Person data into database.
     * @param name person name
     * @param age person age
     * @return inserted person
     */
    Person registerPersonData(String name, Integer age);
}
