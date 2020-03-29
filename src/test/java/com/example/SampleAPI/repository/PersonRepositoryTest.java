package com.example.SampleAPI.repository;

import com.example.SampleAPI.SampleApiApplication;
import com.example.SampleAPI.model.Person;
import com.example.SampleAPI.testlib.CsvDataSetLoader;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SampleApiApplication.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@SpringBootTest
@TestPropertySource(locations = "/application.yml")
@DbUnitConfiguration(dataSetLoader = CsvDataSetLoader.class)
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    @Transactional
    @DatabaseSetup(value = "/dbunit/person.csv")
    public void insertPersonTest() {
        Person person = new Person();
        person.setName("yamada");
        person.setAge(18);
        person.setSex("male");
        person.setJob("front-end engineer");

        personRepository.insertPerson(person);

        List<Person> actualList = personRepository.selectPersonWithName("yamada");
        Assert.assertEquals(4, actualList.size());
        Assert.assertEquals(4, actualList.stream()
                .filter(person::equals)
                .count());
    }

    @Test
    @Transactional
    @DatabaseSetup(value = "/dbunit/person.csv")
    public void selectPersonWithNameTest() {
        List<Person> actualList = personRepository.selectPersonWithName("yamada");
        Assert.assertEquals(actualList.size(), 3);

        actualList = personRepository.selectPersonWithName("yamashita");
        Assert.assertEquals(actualList.size(), 1);

    }
}
