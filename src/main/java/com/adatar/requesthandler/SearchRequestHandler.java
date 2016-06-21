package com.adatar.requesthandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.adatar.resourceloader.BooksFileLoader;
import com.adatar.resourceloader.dtos.BookDto;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SearchRequestHandler {

    @Autowired
    BooksFileLoader booksFileLoader;

    @RequestMapping("/book/isbn/{isbn}")
    public BookDto getBook(@PathVariable String isbn){

        return booksFileLoader.getBook(isbn);

    }

    @RequestMapping("/book/default")
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
