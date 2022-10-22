package com.crud.kodillalibrary.model.rent;

import com.crud.kodillalibrary.model.exceptions.BookNotFoundException;
import com.crud.kodillalibrary.model.exceptions.CopiesNotFoundException;
import com.crud.kodillalibrary.model.exceptions.ReaderNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rent")
public class RentController {

    private final RentService rentService;

    RentController(final RentService rentService) {
        this.rentService = rentService;
    }

    @PostMapping()
    public ResponseEntity<Void> rentBook(@RequestParam Long bookId, @RequestParam Long readerId) throws ReaderNotFoundException, CopiesNotFoundException, BookNotFoundException {
        rentService.rentABook(bookId,readerId);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/return")
    public ResponseEntity<Void> returnABook(@RequestParam Long copiesId, @RequestParam Long readerId) throws CopiesNotFoundException, ReaderNotFoundException {
        rentService.returnABook(copiesId,readerId);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<String> howManyCopiesToRent(@RequestParam Long bookId) throws BookNotFoundException {
        return ResponseEntity.ok(rentService.howManyToRent(bookId));
    }

}
