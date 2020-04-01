package com.example.SampleAPI.service;

import com.example.SampleAPI.model.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookSearchAPIService {

    /**
     * this method is getting data with connecting external api.
     * @param name book name
     * @return book object
     */
    Book searchByName(String name);
    Book searchByIsbn(String name);
}
