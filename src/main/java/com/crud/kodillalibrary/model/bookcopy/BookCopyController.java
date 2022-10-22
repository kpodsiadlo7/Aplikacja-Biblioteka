package com.crud.kodillalibrary.model.bookcopy;

import com.crud.kodillalibrary.model.exceptions.CopiesNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/copy")
public class BookCopyController {

    private final BookCopyService bookCopyService;

    BookCopyController(final BookCopyService bookCopyService) {
        this.bookCopyService = bookCopyService;
    }

    @PatchMapping("/status")
    public ResponseEntity<Void> changeStatus(@RequestBody BookCopyDto bookCopyDto) throws CopiesNotFoundException, IllegalAccessException {
        bookCopyService.changeStatus(bookCopyDto);
        return ResponseEntity.ok().build();
    }
}
