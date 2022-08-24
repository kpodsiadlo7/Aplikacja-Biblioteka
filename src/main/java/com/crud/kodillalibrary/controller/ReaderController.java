package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.main.Reader;
import com.crud.kodillalibrary.main.dto.ReaderDto;
import com.crud.kodillalibrary.mapper.ReaderMapper;
import com.crud.kodillalibrary.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Service
@RequestMapping("readers")
public class ReaderController {
    private final ReaderService readerService;
    private final ReaderMapper readerMapper;

    @GetMapping
    public ResponseEntity<List<ReaderDto>> getReaders(){
        List<Reader> readers = readerService.getAllReaders();
        return ResponseEntity.ok(readerMapper.mapToReaderDtoList(readers));
    }

    @GetMapping(value = "{readerId}")
    public ResponseEntity<ReaderDto> getReaderById(@PathVariable Long readerId) throws NotFoundException{
        return ResponseEntity.ok(readerMapper.mapToReaderDto(readerService.getReadersById(readerId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> newReader(@RequestBody ReaderDto readerDto){
        Reader reader = readerMapper.mapToReader(readerDto);
        readerService.saveNewReader(reader);
        return ResponseEntity.ok().build();
    }

}
