package com.crud.kodillalibrary.model.book;

public class BookDto {
    private Long bookId;
    private String title;
    private String author;
    private int year;

    Long getBookId() {
        return bookId;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    int getYear() {
        return year;
    }

    BookDto(final Long bookId, final String title, final String author, final int year) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
