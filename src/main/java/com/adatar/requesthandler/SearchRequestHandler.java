package com.adatar.requesthandler;

import com.adatar.service.BookService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.adatar.resourceloader.BooksFileLoader;
import com.adatar.resourceloader.dtos.BookDto;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SearchRequestHandler {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book/isbn/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getBook(@PathVariable String isbn){

        return bookService.serviceRequest(isbn);
    }

    @RequestMapping(value = "/book/default", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDto getBook(){

        BookDto book = new BookDto();
        book.setISBN("A123456");
        book.setTitle("CS 101 For Dummies");
        book.setPublisher("Dummy");
        book.setYear(2016);
        book.setImage_s("www.yahoo.com");
        book.setImage_m("www.bing.com");
        book.setImage_l("www.google.com");

        return book;

    }
}
