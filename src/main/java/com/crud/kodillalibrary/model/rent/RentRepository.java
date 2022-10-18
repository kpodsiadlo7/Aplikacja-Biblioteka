package com.crud.kodillalibrary.model.rent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends CrudRepository<Rent,Long> {
}
