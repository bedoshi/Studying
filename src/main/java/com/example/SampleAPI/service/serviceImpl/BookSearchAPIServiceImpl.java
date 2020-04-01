package com.example.SampleAPI.service.serviceImpl;

import com.example.SampleAPI.model.Book;
import com.example.SampleAPI.service.BookSearchAPIService;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class BookSearchAPIServiceImpl implements BookSearchAPIService {
    @Override
    public Book searchByName(String name) {
        // なんか通信する
        JSONObject result = getResultByName(name);
        // 取得した結果をbookにして返却する
        return convertToBook(result);
    }

    // TODO: need to implement
    private Book convertToBook(JSONObject result) {
        return null;
    }

    // TODO: need to implement
    private JSONObject getResultByName(String name) {
        return null;
    }

    @Override
    public Book searchByIsbn(String name) {
        return null;
    }
}
