package com.crud.kodillalibrary.model.readers;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "READERS")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private LocalDateTime createTime;
}
