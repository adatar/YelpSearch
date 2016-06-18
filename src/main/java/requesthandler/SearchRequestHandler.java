package requesthandler;

import com.google.gson.Gson;
import resourceloader.BooksFileLoader;
import resourceloader.dtos.BookDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


class SearchRequestHandler extends HttpServlet{

    @Override
    public void init() throws ServletException {
        BooksFileLoader.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        resp.setContentType("application/json");

        String[] isbns = (String[]) req.getParameterMap().get("isbn");

        ArrayList<BookDto> bookList = new ArrayList<BookDto>();
        for(String isbn : isbns){
            BookDto book = BooksFileLoader.getInstance().getBook(isbn);
            bookList.add(book);
        }

        pw.append(new Gson().toJson(bookList));

    }

    @Override
    protected void finalize() throws Throwable {
    }

    @Override
    public void destroy() {
    }

}
