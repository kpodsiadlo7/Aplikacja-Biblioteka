package com.crud.kodillalibrary.main.dao;

import com.crud.kodillalibrary.main.Readers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ReadersDao extends CrudRepository<Readers,Long> {
}
