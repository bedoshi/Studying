package com.example.SampleAPI.controller.rest;

import com.example.SampleAPI.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // this is same as 'SpringJUnit4ClassRunner.class'
@SpringBootTest
public class SampleParamAPIControllerTest {

    @Autowired
    SampleParamAPIController target;

    MockMvc mockMvc;
    ObjectMapper objectMapper;
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(target).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void personWithAgeTest() {

        Person person = new Person();
        person.setAge(10);

        try {
            mockMvc.perform(get("/api/param/{age}", 10))
                    .andExpect(status().isOk())
                    .andExpect(content().json(objectMapper.writeValueAsString(person)));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void personWithNameAndAgeTest() {

        Person person = new Person();
        person.setAge(10);
        person.setName("yamada");

        try {
            mockMvc.perform(get("/api/param/{age}/{name}", 10, "yamada"))
                    .andExpect(status().isOk())
                    .andExpect(content().json(objectMapper.writeValueAsString(person)));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void personNameFromParamTest() {
        Person person = new Person();
        person.setAge(20);
        person.setName("yamada_taro");

        try {
            mockMvc.perform(get(
                    "/api/param?name={name}&age={age}",
                    "yamada_taro", 20))
                    .andExpect(status().isOk())
                    .andExpect(content().json(objectMapper.writeValueAsString(person)));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}
