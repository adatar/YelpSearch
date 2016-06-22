package com.adatar.service;

import com.adatar.cache.CacheManager;
import com.adatar.resourceloader.BooksFileLoader;
import com.adatar.resourceloader.dtos.BookDto;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

public class BookService {

    @Autowired
    private BooksFileLoader booksFileLoader;

    private CacheManager cacheManager;

    BookService(CacheManager cacheManager){
        this.cacheManager = cacheManager;
    }

    public String serviceRequest(String isbn){

        String cacheValue = (String) cacheManager.get(isbn);
        if(cacheValue != null) return cacheValue;

        BookDto book = booksFileLoader.getBook(isbn);
        return (book == null) ? "" : new Gson().toJson(book);

    }
}
