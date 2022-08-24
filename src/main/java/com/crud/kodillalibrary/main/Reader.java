package com.crud.kodillalibrary.main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "reader")
public class Reader {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "name")
    private String readerName;
    @Column(name = "surname")
    private String readerSurname;
    //@Column(name = "create_date")
    //private Date created;
}
