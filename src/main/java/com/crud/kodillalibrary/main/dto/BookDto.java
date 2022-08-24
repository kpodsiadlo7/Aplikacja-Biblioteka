package com.crud.kodillalibrary.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookDto {
    private Long Id;
    private Long yearPublishment;
    private String bookTitle;
    private String bookAuthor;
}
