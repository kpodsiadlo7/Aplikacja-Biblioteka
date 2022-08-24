package com.crud.kodillalibrary.main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "year_publishment")
    private Long yearPublishment;
    @Column(name = "title")
    private String bookTitle;
    @Column(name = "author")
    private String bookAuthor;
}
