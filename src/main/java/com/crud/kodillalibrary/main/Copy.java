package com.crud.kodillalibrary.main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "copy")
public class Copy {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "title_id")
    private Long titleId;
    @Column(name = "copy_quantity")
    private int copyQty;
    @Column(name = "status")
    private String status;
}
