package com.example.SampleAPI.repository;

import com.example.SampleAPI.SampleApiApplication;
import com.example.SampleAPI.model.Book;
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
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    @Transactional
    @DatabaseSetup(value = "/dbunit/book.csv")
    public void selectAllTest() {
        List<Book> actualList = bookRepository.selectAll();
        Assert.assertEquals(actualList.size(), 2);
        Assert.assertEquals("オブジェクト指向でなぜつくるのか", actualList
                .stream()
                .filter(x -> x.getBook_id() == 1)
                .findFirst()
                .get()
                .getBook_name());
        Assert.assertEquals("アジャイル検定　公式テキスト", actualList
                .stream()
                .filter(x -> x.getBook_id() == 2)
                .findFirst()
                .get()
                .getBook_name());
    }

    @Test
    @Transactional
    @DatabaseSetup(value = "/dbunit/book.csv")
    public void selectByPrimaryKeyTest() {
        Book actual = bookRepository.selectByPrimaryKey(1);
        Assert.assertNotNull(actual);
        Assert.assertEquals("オブジェクト指向でなぜつくるのか", actual.getBook_name());

        actual = bookRepository.selectByPrimaryKey(2);
        Assert.assertNotNull(actual);
        Assert.assertEquals("アジャイル検定　公式テキスト", actual.getBook_name());

    }

    @Test
    @Transactional
    @DatabaseSetup(value = "/dbunit/book.csv")
    public void insertTest() {
        Book book = new Book();
        book.setBook_id(100);
        book.setBook_name("dummy_book_name");
        book.setBook_isbn("978-4-1234-5678");

        bookRepository.insert(book);

        Book actual = bookRepository.selectByPrimaryKey(100);

        Assert.assertNotNull(actual);
        Assert.assertEquals(actual, book);
    }
}
