package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.main.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {

    @Override
    List<Book> findAll();
    @Override
    Optional<Book> findById(Long id);
}