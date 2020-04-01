package com.example.SampleAPI.service.impl;

import com.example.SampleAPI.model.Book;
import com.example.SampleAPI.service.BookSearchAPIService;
import com.example.SampleAPI.service.BookSearchService;
import com.example.SampleAPI.service.serviceImpl.BookSearchServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class BookSearchServiceImplTest {

    @Mock
    BookSearchAPIService bookSearchAPIService;

    @InjectMocks
    BookSearchServiceImpl bookSearchService;

    @Test
    public void searchByIsbnTest() {
        Book dummyBook = new Book();
        dummyBook.setBook_isbn("dummy_isbn");
        dummyBook.setBook_name("dummy_name");

        when(bookSearchAPIService.searchByIsbn(anyString())).thenReturn(dummyBook);

        Book actual = bookSearchService.searchByIsbn("dummy_isbn");

        Assert.assertEquals("dummy_isbn", actual.getBook_isbn());
        Assert.assertEquals("dummy_name", actual.getBook_name());
    }

    @Test
    public void searchByNameTest() {
        Book dummyBook = new Book();
        dummyBook.setBook_isbn("dummy_isbn");
        dummyBook.setBook_name("dummy_name");

        when(bookSearchAPIService.searchByName(anyString())).thenReturn(dummyBook);

        Book actual = bookSearchService.searchByName("dummy_name");
        Assert.assertEquals("dummy_isbn", actual.getBook_isbn());
        Assert.assertEquals("dummy_name", actual.getBook_name());
    }
}
