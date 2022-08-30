package com.crud.kodillalibrary.main;

import javax.validation.constraints.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "COPY_BOOK")
public class CopyBook{
    private Long id;
    private String status;
    private int amount;
    private Book book;

    public CopyBook() {
    }

    public CopyBook(String status, int amount) {
        this.status = status;
        this.amount = amount;
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
    @JoinColumn(name = "TITLE_ID")
    public Book getBook() {
        return book;
    }

    @Column(name = "BOOK_AMOUNT")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setCopyBook(Book book){
        this.book = book;
    }

    private void setId(Long id){
        this.id = id;
    }

    private void setStatus(String status){
        this.status = status;
    }
}