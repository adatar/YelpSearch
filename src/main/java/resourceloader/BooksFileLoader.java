package resourceloader;

import org.springframework.beans.factory.annotation.Value;
import resourceloader.dtos.BookDto;

import java.util.ArrayList;
import java.util.HashMap;

public class BooksFileLoader implements Loadable{

    private static BooksFileLoader ourInstance = new BooksFileLoader();
    private HashMap<String, BookDto> books;

    private String bookFilePath = "/tmp/books.csv";

    public static BooksFileLoader getInstance() {
        return ourInstance;
    }

    private BooksFileLoader() {
        books = new HashMap<String, BookDto>();
        load();
    }

    public void load() {

        try {
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
            book.setYearOfPublication(Integer.parseInt(bookAttributes[3].replace("\"","")));
            book.setPublisher(bookAttributes[4].replace("\"",""));
            book.setImageUrl_S(bookAttributes[5].replace("\"",""));
            book.setImageUrl_M(bookAttributes[6].replace("\"",""));
            book.setImageUrl_L(bookAttributes[7].replace("\"",""));

            books.put(book.getISBN(), book);

        }

    }

    public BookDto getBook(String isbn) {
        return books.get(isbn);
    }
}
