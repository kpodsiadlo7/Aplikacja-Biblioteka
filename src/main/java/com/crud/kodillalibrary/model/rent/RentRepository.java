package com.crud.kodillalibrary.model.rent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentRepository extends CrudRepository<Rent,Long> {

    Optional<Rent> findByBookCopyId(Long copyId);
}
