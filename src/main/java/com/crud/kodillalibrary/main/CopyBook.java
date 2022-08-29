package com.crud.kodillalibrary.main;

import javax.validation.constraints.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "COPY_BOOK")
public class CopyBook{
    private Long id;
    private String status;
    private Book book;

    public CopyBook() {
    }

    public CopyBook(String status) {
        this.status = status;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId(){
        return id;
    }


    @Column(name = "STATUS")
    public String getStatus(){
        return status;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK_ID")
    public Book getBook() {
        return book;
    }



    public void setBook(Book book) {
        this.book = book;
    }

    private void setCopyBook(Book book){
        this.book = book;
    }

    private void setId(Long id){
        this.id = id;
    }

    private void setStatus(String status){
        this.status = status;
    }
}