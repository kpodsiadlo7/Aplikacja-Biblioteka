package com.crud.kodillalibrary.main;

import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "BOOK")
public class Book{
    private Long id;
    private int yearPublishment;
    private String title;
    private String author;

    public Book(){
    }

    public Book(int yearPublishment, String title, String author){
        this.yearPublishment = yearPublishment;
        this.title = title;
        this.author = author;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId(){
        return id;
    }

    @Column(name = "BOOK_TITLE")
    public String getTitle(){
        return title;
    }

    @Column(name = "BOOK_AUTHOR")
    public String getAuthor(){
            return author;
    }

    @Column(name = "YEAR_PUBLISHMENT")
    @NotNull
    public int getYearPublishment(){
        return yearPublishment;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    private void setYearPublishment(int yearPublishment) {
        this.yearPublishment = yearPublishment;
    }

}