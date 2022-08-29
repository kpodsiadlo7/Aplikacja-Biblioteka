package com.crud.kodillalibrary.main.dao;

import com.crud.kodillalibrary.main.CopyBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CopyBookDao extends CrudRepository<CopyBook,Long> {

    List<CopyBook> findByStatus(String status);
}
