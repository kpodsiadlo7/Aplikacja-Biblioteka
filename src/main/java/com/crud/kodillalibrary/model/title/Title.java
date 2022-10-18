package com.crud.kodillalibrary.model.title;

import javax.persistence.*;

@Entity
@Table(name = "TITLES")
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private int year;

    public Title() {
    }
}
