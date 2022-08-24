package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.main.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReaderRepository extends CrudRepository<Reader,Long> {

    @Override
    List<Reader> findAll();
    @Override
    Optional<Reader> findById(Long id);
}