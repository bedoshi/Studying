package com.example.SampleAPI.service;

import com.example.SampleAPI.model.Book;
import org.springframework.stereotype.Service;

/**
 * This is service for searching book
 */
@Service
public interface BookSearchService {

    /**
     * this is search method with isbn code.
     * @param isbn isbn
     * @return book object
     */
    Book searchByIsbn(String isbn);

    /**
     * this is search method with book name
     * @param name book name
     * @return book object
     */
    Book searchByName(String name);
}
