package com.crud.kodillalibrary.model.rent;

import javax.persistence.*;

@Entity
@Table(name = "RENTS")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
