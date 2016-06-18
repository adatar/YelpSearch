package resourceloader.dtos;


public class BookDto {

    String ISBN;
    String title;
    String author;
    Integer yearOfPublication;
    String publisher;
    String imageUrl_S;
    String imageUrl_M;
    String imageUrl_L;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImageUrl_S() {
        return imageUrl_S;
    }

    public void setImageUrl_S(String imageUrl_S) {
        this.imageUrl_S = imageUrl_S;
    }

    public String getImageUrl_M() {
        return imageUrl_M;
    }

    public void setImageUrl_M(String imageUrl_M) {
        this.imageUrl_M = imageUrl_M;
    }

    public String getImageUrl_L() {
        return imageUrl_L;
    }

    public void setImageUrl_L(String imageUrl_L) {
        this.imageUrl_L = imageUrl_L;
    }
}
