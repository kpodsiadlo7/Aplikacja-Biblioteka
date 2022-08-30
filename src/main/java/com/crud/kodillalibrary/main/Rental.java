package com.crud.kodillalibrary.main;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RENTAL")
public class Rental{
    private Long id;
    private Date rentDate;
    private CopyBook copyBook;
    private Readers readers;

    public Rental(Date rentDate) {
        this.rentDate = new Date();
    }

    public Rental() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId(){
        return id;
    }

    @NotNull
    @Column(name = "RENT_DATE")
    public Date getRentDate(){
        return rentDate;
    }

    @ManyToOne
    @JoinColumn(name = "COPY_BOOK_ID")
    public CopyBook getCopyBook(){
        return copyBook;
    }

    @OneToOne
    @JoinColumn(name = "READER_ID")
    public Readers getReaders(){
        return readers;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public void setCopyBook(CopyBook copyBook) {
        this.copyBook = copyBook;
    }

    public void setReaders(Readers readers) {
        this.readers = readers;
    }
}