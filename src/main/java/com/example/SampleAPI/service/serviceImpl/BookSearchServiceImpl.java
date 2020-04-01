package com.example.SampleAPI.service.serviceImpl;

import com.example.SampleAPI.model.Book;
import com.example.SampleAPI.service.BookSearchAPIService;
import com.example.SampleAPI.service.BookSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class BookSearchServiceImpl implements BookSearchService {

    @Autowired
    BookSearchAPIService bookSearchAPIService;

    @Override
    public Book searchByIsbn(String isbn) {
        if (StringUtils.isEmpty(isbn)) return null;
        return bookSearchAPIService.searchByIsbn(isbn);
    }

    @Override
    public Book searchByName(String name) {
        if (StringUtils.isEmpty(name)) return null;
        return bookSearchAPIService.searchByName(name);
    }
}
