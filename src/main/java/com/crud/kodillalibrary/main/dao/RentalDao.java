package com.crud.kodillalibrary.main.dao;

import com.crud.kodillalibrary.main.Rental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RentalDao extends CrudRepository<Rental,Long> {
}
