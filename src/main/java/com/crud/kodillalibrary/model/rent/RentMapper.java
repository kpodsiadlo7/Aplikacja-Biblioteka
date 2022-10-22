package com.crud.kodillalibrary.model.rent;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RentMapper {

    public Rent mapToRent(){
        return new Rent();
    }
    public Rent returnCopies(Long rentId){
        return new Rent(
                rentId,
                LocalDateTime.now()
        );
    }
}
