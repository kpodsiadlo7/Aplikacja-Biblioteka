package com.crud.kodillalibrary.main;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "READERS")
public class Readers{
    private Long id;
    private String readerName;
    private String readerSurname;
    private Date createdReader;

    public Readers(){
    }

    public Readers(String readerName, String readerSurname){
        this.readerName = readerName;
        this.readerSurname = readerSurname;
        this.createdReader = new Date();
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId(){
        return id;
    }

    @Column(name = "READER_NAME")
    public String getReaderName(){
        return readerName;
    }

    @Column(name = "READER_SURNAME")
    public String getReaderSurname(){
        return readerSurname;
    }

    @Column(name = "CREATED")
    @NotNull
    public Date getCreatedReader(){
        return createdReader;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    private void setReaderSurname(String readerSurname) {
        this.readerSurname = readerSurname;
    }

    private void setCreatedReader(Date created) {
        this.createdReader = created;
    }
}