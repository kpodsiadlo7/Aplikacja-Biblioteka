package com.crud.kodillalibrary.model.book;

import com.crud.kodillalibrary.model.exceptions.BookNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Boolean> createNewBook(@RequestBody BookDto bookDto) throws BookNotFoundException {
        bookService.createNewBook(bookDto);
        return ResponseEntity.ok().build();
    }
}
