package com.adatar.resourceloader.dtos;


public class BookDto {

    private String ISBN;
    private String title;
    private String author;
    private Integer year;
    private String publisher;
    private String image_s;
    private String image_m;
    private String image_l;

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImage_s() {
        return image_s;
    }

    public void setImage_s(String image_s) {
        this.image_s = image_s;
    }

    public String getImage_m() {
        return image_m;
    }

    public void setImage_m(String image_m) {
        this.image_m = image_m;
    }

    public String getImage_l() {
        return image_l;
    }

    public void setImage_l(String image_l) {
        this.image_l = image_l;
    }
}
