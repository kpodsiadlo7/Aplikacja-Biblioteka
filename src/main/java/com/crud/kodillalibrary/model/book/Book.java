package com.crud.kodillalibrary.model.book;

import com.crud.kodillalibrary.model.bookcopy.BookCopy;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BOOKS")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private int year;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private List<BookCopy> books;

    public Book() {
    }

    public Book(final String title, final String author, final int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.books = new ArrayList<>();
    }

    Long getId() {
        return id;
    }

    void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    void setTitle(final String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    void setAuthor(final String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    void setYear(final int year) {
        this.year = year;
    }

    public List<BookCopy> getBooks() {
        return books;
    }

    void setBooks(final List<BookCopy> books) {
        this.books = books;
    }
}
