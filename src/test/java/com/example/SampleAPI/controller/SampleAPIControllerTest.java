package com.example.SampleAPI.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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

    @Test
    public void indexTest() {
        SampleAPIController controller = new SampleAPIController();
        Assert.assertEquals("hello world", controller.index());
    }

    @Test
    public void canAccessToIndexTest() {

        mockMvc = MockMvcBuilders.standaloneSetup(target).build();
        try {
            mockMvc.perform(get("/api/index"))
            .andExpect(status().isOk())
            .andExpect(content().string("hello world"));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }
}
