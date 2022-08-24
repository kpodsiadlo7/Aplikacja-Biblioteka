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
@Entity(name = "book_rental")
public class BookRental {
    @Id
    @NotNull
    @Column(name = "id", unique = true)
    @GeneratedValue
    private Long copyId;
    @Column(name = "readerId")
    private Long readerId;
    @Column(name = "created_date")
    private Date created;
}
