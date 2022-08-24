package com.crud.kodillalibrary.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ReaderDto {
    private Long id;
    private String readerName;
    private String readerSurname;
   // private Date created;
}
