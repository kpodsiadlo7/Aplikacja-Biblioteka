package com.crud.kodillalibrary.model.book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookMapper {

    public Book mapToBook(final BookDto bookDto){
        return new Book(
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getYear()
        );
    }

    public BookDto mapToBookDto(final Book book){
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getYear()
        );
    }

    public List<BookDto> mapToBookDtoList(final List<Book> books){
        return books.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }

}
