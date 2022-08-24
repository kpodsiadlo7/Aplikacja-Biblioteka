package com.crud.kodillalibrary.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CopyDto {
    private Long id;
    private Long titleId;
    private int copyQty;
    private String status;
}
