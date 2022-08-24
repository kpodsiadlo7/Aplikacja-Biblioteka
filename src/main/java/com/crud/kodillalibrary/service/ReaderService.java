package com.crud.kodillalibrary.service;

import com.crud.kodillalibrary.controller.NotFoundException;
import com.crud.kodillalibrary.main.Reader;
import com.crud.kodillalibrary.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReaderService {
    private final ReaderRepository repository;

    public List<Reader> getAllReaders(){
        return repository.findAll();
    }

    public Reader getReadersById(final Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Reader saveNewReader(final Reader reader){
        return repository.save(reader);
    }
}
