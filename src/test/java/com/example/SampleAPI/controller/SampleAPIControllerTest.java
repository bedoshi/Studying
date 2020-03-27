package com.example.SampleAPI.controller;

import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
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
}
