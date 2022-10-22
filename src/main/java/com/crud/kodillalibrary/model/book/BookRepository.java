package com.crud.kodillalibrary.model.book;

import com.crud.kodillalibrary.model.bookcopy.BookCopy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepository extends CrudRepository<Book,Long> {

    boolean existsByTitleAndAuthorAndYear(final String title, final String author, final int year);
    Optional<Book> findByTitleAndAuthorAndYear(final String title, final String author, final int year);
}
