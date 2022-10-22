package com.crud.kodillalibrary.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFoundException() {
        return new ResponseEntity<>("Book not found!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CopiesNotFoundException.class)
    public ResponseEntity<Object> handleCopiesNotFoundException() {
        return new ResponseEntity<>("STATUS ONLY 1-LOST, 2-DESTROY, 3-RENT, 4-TO_RENT", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReaderNotFoundException.class)
    public ResponseEntity<Object> handleReaderNotFoundException() {
        return new ResponseEntity<>("Reader not found!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RentNotFoundException.class)
    public ResponseEntity<Object> handleRentNotFoundException() {
        return new ResponseEntity<>("This rent doesn't exist!", HttpStatus.BAD_REQUEST);
    }
}
