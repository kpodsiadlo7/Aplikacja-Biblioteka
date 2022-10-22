package com.crud.kodillalibrary.model.bookcopy;

import com.crud.kodillalibrary.model.book.Book;
import com.crud.kodillalibrary.model.exceptions.CopiesNotFoundException;
import com.crud.kodillalibrary.model.readers.Reader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCopyService {

    private final BookCopyRepository bookCopyRepository;

    BookCopyService(final BookCopyRepository bookCopyRepository) {
        this.bookCopyRepository = bookCopyRepository;
    }

    public BookCopy createNewBook(){
        BookCopy copy = new BookCopy(BookStatus.TO_RENT);
        bookCopyRepository.save(copy);
        return copy;
    }
    public void changeStatus(BookCopyDto bookCopyDto) throws CopiesNotFoundException{
        if (!bookCopyRepository.existsById(bookCopyDto.getCopyBookId()))
            throw new CopiesNotFoundException();

        if (bookCopyDto.getStatusId() > 0 && bookCopyDto.getStatusId() < 5) {
            BookCopy bookCopy = bookCopyRepository.findById(bookCopyDto.getCopyBookId()).orElseThrow(CopiesNotFoundException::new);
            if (bookCopyDto.getStatusId() == 1)
                bookCopy.setStatus(BookStatus.LOST);
            if (bookCopyDto.getStatusId() == 2)
                bookCopy.setStatus(BookStatus.DESTROY);
            if (bookCopyDto.getStatusId() == 3)
                bookCopy.setStatus(BookStatus.RENT);
            if (bookCopyDto.getStatusId() == 4)
                bookCopy.setStatus(BookStatus.TO_RENT);
            bookCopyRepository.save(bookCopy);
        } else throw new CopiesNotFoundException();
    }
    public BookCopy changeStatusByRent(Long copiesId) throws CopiesNotFoundException {
        BookCopy bookToRent = bookCopyRepository.findById(copiesId).orElseThrow(CopiesNotFoundException::new);
        bookToRent.setStatus(BookStatus.RENT);
        return bookCopyRepository.save(bookToRent);
    }
    public BookCopy findCopy(Long copyId) throws CopiesNotFoundException {
        if (!bookCopyRepository.existsById(copyId))
            throw new CopiesNotFoundException();
        return bookCopyRepository.findById(copyId).orElseThrow(CopiesNotFoundException::new);
    }
    public void returnABook(Long copiesId) throws CopiesNotFoundException {
        if (!bookCopyRepository.existsById(copiesId))
            throw new CopiesNotFoundException();
        BookCopy bookCopy = bookCopyRepository.findById(copiesId).orElseThrow(CopiesNotFoundException::new);
        bookCopy.setStatus(BookStatus.TO_RENT);
        bookCopyRepository.save(bookCopy);
    }
    public BookCopy copyToDelete(Reader reader, Long copiesId) throws CopiesNotFoundException {
        return reader.getBookCopies().stream()
                .filter(bookCopy -> bookCopy.getId().equals(copiesId))
                .findFirst().orElseThrow(CopiesNotFoundException::new);
    }
}
