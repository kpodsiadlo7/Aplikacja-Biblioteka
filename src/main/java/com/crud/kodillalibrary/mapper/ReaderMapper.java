package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.main.Reader;
import com.crud.kodillalibrary.main.dto.ReaderDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReaderMapper {

    public Reader mapToReader(final ReaderDto readerDto){
        return new Reader(
                readerDto.getId(),
                readerDto.getReaderName(),
                readerDto.getReaderSurname()
        );
    }

    public ReaderDto mapToReaderDto(final Reader reader){
        return new ReaderDto(
                reader.getId(),
                reader.getReaderName(),
                reader.getReaderSurname()
        );
    }

    public List<ReaderDto> mapToReaderDtoList(final List<Reader> readerList){
        return readerList.stream()
                .map(this::mapToReaderDto)
                .collect(Collectors.toList());
    }
}
