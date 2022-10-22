package com.crud.kodillalibrary.model.readers;

import org.springframework.stereotype.Service;

@Service
public class ReaderMapper {

    public Reader mapToReader(final ReaderDto readerDto){
        return new Reader(
                readerDto.getName(),
                readerDto.getSurname()
        );
    }

    public ReaderDto mapToReaderDto(final Reader reader){
        return new ReaderDto(
                reader.getId(),
                reader.getName(),
                reader.getSurname()
        );
    }
}
