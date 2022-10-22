package com.crud.kodillalibrary.model.rent;

import com.crud.kodillalibrary.model.book.Book;
import com.crud.kodillalibrary.model.book.BookService;
import com.crud.kodillalibrary.model.bookcopy.BookCopy;
import com.crud.kodillalibrary.model.bookcopy.BookCopyService;
import com.crud.kodillalibrary.model.bookcopy.BookStatus;
import com.crud.kodillalibrary.model.exceptions.BookNotFoundException;
import com.crud.kodillalibrary.model.exceptions.CopiesNotFoundException;
import com.crud.kodillalibrary.model.exceptions.ReaderNotFoundException;
import com.crud.kodillalibrary.model.readers.Reader;
import com.crud.kodillalibrary.model.readers.ReaderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class RentService {

    private final RentRepository rentRepository;
    private final RentMapper rentMapper;
    private final ReaderService readerService;
    private final BookCopyService bookCopyService;
    private final BookService bookService;

    RentService(final RentRepository rentRepository, final RentMapper rentMapper, final ReaderService readerService, final BookCopyService bookCopyService, final BookService bookService) {
        this.rentRepository = rentRepository;
        this.rentMapper = rentMapper;
        this.readerService = readerService;
        this.bookCopyService = bookCopyService;
        this.bookService = bookService;
    }

    void rentABook(Long bookId, Long readerId) throws ReaderNotFoundException, CopiesNotFoundException, BookNotFoundException {
        Book book = bookService.getBook(bookId);
        List<BookCopy> bookCopies = book.getBooks().stream()
                .filter(bookCopy -> bookCopy.getStatus().equals(BookStatus.TO_RENT))
                .collect(Collectors.toList());
        Long copiesId = bookCopies.stream()
                .map(BookCopy::getId)
                .findFirst().orElseThrow(CopiesNotFoundException::new);
        Rent rent = rentMapper.mapToRent();
        Reader reader = readerService.findReader(readerId);
        rentRepository.save(setCopiesToRent(rent,bookCopyService.findCopy(copiesId)));
        reader.getRent().add(rent);
        readerService.saveReader(reader);
        readerService.rentABook(bookCopyService.changeStatusByRent(copiesId),readerId);
    }

    void returnABook(Long copiesId,Long readerId) throws CopiesNotFoundException, ReaderNotFoundException {
        bookCopyService.returnABook(copiesId);
        Rent rent = rentRepository.findByBookCopyId(copiesId).orElseThrow(CopiesNotFoundException::new);
        readerService.returnABook(readerId,copiesId);
        rent.setReturnDate(LocalDateTime.now());
        rentRepository.save(rent);
    }

    Rent setCopiesToRent(final Rent rent, final BookCopy copy){
        rent.setBookCopy(copy);
        return rent;
    }

    String howManyToRent(Long bookId) throws BookNotFoundException {
        Book book = bookService.getBook(bookId);
        List<BookCopy> copiesToRent = book.getBooks().stream()
                .filter(bookCopy -> bookCopy.getStatus().equals(BookStatus.TO_RENT))
                .collect(Collectors.toList());
        return String.format("Pieces of %s %s %d for rent: %d",book.getTitle(),book.getAuthor(),book.getYear(),copiesToRent.size());
    }
}
