package com.example.kirpputori.model.User.Product;

import jakarta.persistence.Entity;

@Entity
public class Book extends Product {

    private final String type = "Book";
    private String isbn;
    private String author;

    public Book() {
        super();
    }

    public Book(String name, double price, String description, String isbn, String author) {
        super(name, price, description);
        this.isbn = isbn;
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return super.toString() + "type=" + type + ", isbn=" + isbn + ", author=" + author + "]";
    }

}
