package com.example.SampleAPI.controller.rest;

import com.example.SampleAPI.controller.rest.SampleAPIController;
import com.example.SampleAPI.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SampleAPIControllerTest {

    @Autowired
    SampleAPIController target;

    MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(target).build();
    }

    @Test
    public void canAccessToIndexTest() {
        try {
            mockMvc.perform(get("/api/index"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("hello world"));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void canAccessToPersonTest() {
        try {
            mockMvc.perform(get("/api/person"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("{\"person\":{\"name\":\"yamada taro\",\"age\":20}}"));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void canAccessToPersonJsonTest() {
        try {
            Map<String,Object> param = new HashMap<>();
            param.put("age", "20");
            param.put("sex", "man");

            JSONObject jsonObj = new JSONObject(param);

            mockMvc.perform(get("/api/person_json"))
                    .andExpect(status().isOk())
                    .andExpect(content().json(jsonObj.toString()));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void canAccessToPersonObjTest() {
        Person person = new Person();
        person.setAge(10);
        person.setName("yamada taro");
        person.setJob("front-end engineer");
        person.setSex("male");

        Person father = new Person("yamada jiro", 40, "male", "server side engineer");
        List<Person> fathersFamily = new ArrayList<>();
        father.setFamily(fathersFamily);
        List<Person> family = new ArrayList<>();
        family.add(father);

        person.setFamily(family);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String expectedJson = mapper.writeValueAsString(person);
            mockMvc.perform(get("/api/person_obj"))
                    .andExpect(status().isOk())
                    .andExpect(content().json(expectedJson));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
