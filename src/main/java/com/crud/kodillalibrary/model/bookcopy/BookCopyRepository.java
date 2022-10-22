package com.crud.kodillalibrary.model.bookcopy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookCopyRepository extends CrudRepository<BookCopy, Long> {

    List<BookCopy> findByStatus(BookStatus status);

    @Override
    Optional<BookCopy> findById(Long id);

}
