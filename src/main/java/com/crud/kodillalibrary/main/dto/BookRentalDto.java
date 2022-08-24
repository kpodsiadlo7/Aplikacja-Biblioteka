package com.crud.kodillalibrary.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BookRentalDto {
    private Long copyId;
    private Long readerId;
    private LocalDate date;
}
