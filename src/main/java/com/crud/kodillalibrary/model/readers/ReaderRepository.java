package com.crud.kodillalibrary.model.readers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends CrudRepository<Reader,Long> {
}
