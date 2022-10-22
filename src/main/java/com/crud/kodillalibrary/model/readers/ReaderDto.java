package com.crud.kodillalibrary.model.readers;

public class ReaderDto {
    private Long readerId;
    private String name;
    private String surname;

    ReaderDto(final Long readerId, final String name, final String surname) {
        this.readerId = readerId;
        this.name = name;
        this.surname = surname;
    }

    Long getReaderId() {
        return readerId;
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }
}
