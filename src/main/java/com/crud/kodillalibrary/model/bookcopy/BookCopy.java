package com.crud.kodillalibrary.model.bookcopy;

import com.crud.kodillalibrary.model.book.Book;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COPIES")
public class BookCopy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BookStatus status;

    BookCopy(final BookStatus status) {
        this.status = status;
    }

    BookCopy(final Long id, final BookStatus status) {
        this.id = id;
        this.status = status;
    }

    public BookCopy() {

    }

    public Long getId() {
        return id;
    }

    void setId(final Long id) {
        this.id = id;
    }

    public BookStatus getStatus() {
        return status;
    }

    void setStatus(final BookStatus status) {
        this.status = status;
    }

}
