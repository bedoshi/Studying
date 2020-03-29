package com.example.SampleAPI.service.impl;

import com.example.SampleAPI.controller.response.Person;
import com.example.SampleAPI.exception.PersonUnder18Exception;
import com.example.SampleAPI.repository.PersonRepository;
import com.example.SampleAPI.service.serviceImpl.SamplePersonServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class SamplePersonServiceImplTest {

    @Mock
    PersonRepository personRepository;
    @InjectMocks
    SamplePersonServiceImpl samplePersonService;

    @Test
    public void registerPersonDataWithOver18Test() {
        when(this.personRepository.insertPerson(any())).thenReturn(0);

        Person expected = new Person();
        expected.setName("yamada");
        expected.setAge(18);

        Person person = samplePersonService.registerPersonData("yamada", 18);

        Assert.assertEquals("yamada", person.getName());
        Assert.assertEquals(18, person.getAge());

        verify(this.personRepository, times(1)).insertPerson(expected);
    }

    @Test
    public void registerPersonDataWithUnder18Test() {

        when(this.personRepository.insertPerson(any())).thenReturn(0);

        try {
            samplePersonService.registerPersonData("yamada", 17);
            fail();
        } catch (PersonUnder18Exception exception) {
            // do nothing.
        } catch (Exception e) {
            fail();
        }
    }
}
