package com.crud.kodillalibrary.model.readers;

import com.crud.kodillalibrary.model.bookcopy.BookCopy;
import com.crud.kodillalibrary.model.rent.Rent;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "READERS")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private LocalDateTime createTime;
    public Reader() {
    }


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "reader_id")
    private List<Rent> rent;

    @ManyToMany
    @JoinTable(
            name = "RentInfo",
            joinColumns = @JoinColumn(name = "reader_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<BookCopy> bookCopies;

    public Reader(final String name, final String surname) {
        this.name = name;
        this.surname = surname;
        this.createTime = LocalDateTime.now();
    }
    public Reader(final Long id, final String name, final String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    Long getId() {
        return id;
    }

    void setId(final Long id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    String getSurname() {
        return surname;
    }

    void setSurname(final String surname) {
        this.surname = surname;
    }

    LocalDateTime getCreateTime() {
        return createTime;
    }

    void setCreateTime(final LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public List<BookCopy> getBookCopies() {
        return bookCopies;
    }

    void setBookCopies(final List<BookCopy> bookCopies) {
        this.bookCopies = bookCopies;
    }

    public List<Rent> getRent() {
        return rent;
    }

    public void setRent(final List<Rent> rent) {
        this.rent = rent;
    }
}
