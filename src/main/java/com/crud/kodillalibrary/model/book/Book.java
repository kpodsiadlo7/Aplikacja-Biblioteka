package com.crud.kodillalibrary.model.book;

import com.crud.kodillalibrary.model.title.Title;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Book() {
    }
}
