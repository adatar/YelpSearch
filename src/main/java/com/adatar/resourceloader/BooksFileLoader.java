package com.adatar.resourceloader;

import com.adatar.resourceloader.dtos.BookDto;
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;

public class BooksFileLoader implements Loadable{

    @Value("${bookFilePath}")
    private String bookFilePath;

    private HashMap<String, BookDto> books;

    public BooksFileLoader() {
        books = new HashMap<String, BookDto>();
    }

    @PostConstruct
    public void load() {
        try {
            System.out.println(bookFilePath);
            ArrayList<String> fileLines = TextFileLoader.readFile(bookFilePath);
            createBookMap(fileLines);
        }
        catch (Exception e){
            System.out.println("File not found");
        }
    }

    private void createBookMap(ArrayList<String> fileLines){

        for(String line : fileLines){
            BookDto book = new BookDto();
            String[] bookAttributes = line.split(";");

            if(bookAttributes.length < 8) continue;

            book.setISBN(bookAttributes[0].replace("\"",""));
            book.setTitle(bookAttributes[1].replace("\"",""));
            book.setAuthor(bookAttributes[2].replace("\"",""));
            book.setYear(Integer.parseInt(bookAttributes[3].replace("\"","")));
            book.setPublisher(bookAttributes[4].replace("\"",""));
            book.setImage_s(bookAttributes[5].replace("\"",""));
            book.setImage_m(bookAttributes[6].replace("\"",""));
            book.setImage_l(bookAttributes[7].replace("\"",""));

            books.put(book.getISBN(), book);

        }
    }

    public BookDto getBook(String isbn) {
        return books.get(isbn);
    }
}
