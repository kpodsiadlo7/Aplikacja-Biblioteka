package com.crud.kodillalibrary.model.title;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends CrudRepository<Title,Long> {
}
