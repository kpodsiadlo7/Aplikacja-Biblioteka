package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.main.Book;
import com.crud.kodillalibrary.main.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookMapper {

    public Book mapToBook(final BookDto bookDto){
        return new Book(
                bookDto.getId(),
                bookDto.getYearPublishment(),
                bookDto.getBookTitle(),
                bookDto.getBookAuthor()
        );
    }

    public BookDto mapToBookDto(final Book book){
        return new BookDto(
                book.getId(),
                book.getYearPublishment(),
                book.getBookTitle(),
                book.getBookAuthor()
        );
    }

    public List<BookDto> mapToReaderDtoList(final List<Book> bookList){
        return bookList.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }
}