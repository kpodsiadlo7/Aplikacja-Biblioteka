package com.crud.kodillalibrary.service;

import com.crud.kodillalibrary.controller.NotFoundException;
import com.crud.kodillalibrary.main.Book;
import com.crud.kodillalibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository repository;

    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    public Book getBookById(final Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Book saveNewBook(final Book book){
        return repository.save(book);
    }

    public void deleteBookById(final Long id){
        repository.deleteById(id);
    }
}