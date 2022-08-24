package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.main.Book;
import com.crud.kodillalibrary.main.dto.BookDto;
import com.crud.kodillalibrary.mapper.BookMapper;
import com.crud.kodillalibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Service
@RequestMapping("books")
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping
    public ResponseEntity<List<BookDto>> getBooks(){
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(bookMapper.mapToReaderDtoList(books));
    }

    @GetMapping(value = "{bookId}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long bookId) throws NotFoundException{
        return ResponseEntity.ok(bookMapper.mapToBookDto(bookService.getBookById(bookId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> newBook(@RequestBody BookDto bookDto){
        Book book = bookMapper.mapToBook(bookDto);
        bookService.saveNewBook(book);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId){
        bookService.deleteBookById(bookId);
        return ResponseEntity.ok().build();
    }
}