package com.crud.kodillalibrary.model.rent;

import com.crud.kodillalibrary.model.bookcopy.BookCopy;
import com.crud.kodillalibrary.model.readers.Reader;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "RENTS")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime rentDate;
    private LocalDateTime returnDate;

    @OneToOne
    private BookCopy bookCopy;

    public Rent() {
        this.rentDate = LocalDateTime.now();
    }

    Rent(final Long id, final LocalDateTime returnDate) {
        this.id = id;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    LocalDateTime getRentDate() {
        return rentDate;
    }

    void setRentDate(final LocalDateTime rentDate) {
        this.rentDate = rentDate;
    }

    LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(final LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    BookCopy getBookCopy() {
        return bookCopy;
    }

    void setBookCopy(final BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }
}
