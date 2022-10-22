package com.crud.kodillalibrary.model.readers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reader")
public class ReaderController {

    private final ReaderService readerService;

    ReaderController(final ReaderService readerService) {
        this.readerService = readerService;
    }

    @PostMapping
    public ResponseEntity<ReaderDto> addNewReader(@RequestBody ReaderDto readerDto) {
        readerService.createNewReader(readerDto);
        return ResponseEntity.ok().build();
    }
}
