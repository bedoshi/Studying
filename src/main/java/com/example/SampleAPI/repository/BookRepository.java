package com.example.SampleAPI.repository;

import com.example.SampleAPI.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BookRepository {

    /**
     * get all record of book table.
     * @return book list.
     */
    List<Book> selectAll();

    /**
     * get book record by primary key.
     * @param bookId book id (pk)
     * @return book object
     */
    Book selectByPrimaryKey(int bookId);

    /**
     * insert with book object.
     * @param book book object
     * @return number of inserted book.
     */
    int insert(Book book);
}
