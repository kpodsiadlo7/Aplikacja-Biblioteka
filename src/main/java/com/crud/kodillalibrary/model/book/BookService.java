package com.crud.kodillalibrary.model.book;

import com.crud.kodillalibrary.model.bookcopy.BookCopy;
import com.crud.kodillalibrary.model.bookcopy.BookCopyService;
import com.crud.kodillalibrary.model.exceptions.BookNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;
    private final BookCopyService bookCopyService;

    BookService(final BookMapper bookMapper, final BookRepository bookRepository, final BookCopyService bookCopyService) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
        this.bookCopyService = bookCopyService;
    }
    boolean createNewBook(BookDto bookDto) throws BookNotFoundException {
        if (!bookRepository.existsByTitleAndAuthorAndYear(bookDto.getTitle(), bookDto.getAuthor(), bookDto.getYear())){
        Book book = bookMapper.mapToBook(bookDto);
        BookCopy bookCopy = bookCopyService.createNewBook();
        bookRepository.save(book);
        saveBook(book,bookCopy);
        return true;
        }
        Book book = bookRepository.findByTitleAndAuthorAndYear(bookDto.getTitle(), bookDto.getAuthor(), bookDto.getYear()).orElseThrow(BookNotFoundException::new);
        book.getBooks().add(bookCopyService.createNewBook());
        bookRepository.save(book);
        return true;
    }
    public Book getBook(Long bookId) throws BookNotFoundException {
        if (!bookRepository.existsById(bookId))
            throw new BookNotFoundException();
        return bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
    }
    void saveBook(Book book, BookCopy bookCopy){
        book.getBooks().add(bookCopy);
        bookRepository.save(book);
    }
}
