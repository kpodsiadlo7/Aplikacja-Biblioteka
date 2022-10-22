package com.crud.kodillalibrary.model.readers;

import com.crud.kodillalibrary.model.bookcopy.BookCopy;
import com.crud.kodillalibrary.model.bookcopy.BookCopyService;
import com.crud.kodillalibrary.model.exceptions.CopiesNotFoundException;
import com.crud.kodillalibrary.model.exceptions.ReaderNotFoundException;
import com.crud.kodillalibrary.model.rent.Rent;
import org.springframework.stereotype.Service;

@Service
public class ReaderService {

    private final ReaderRepository readerRepository;
    private final ReaderMapper readerMapper;
    private final BookCopyService copyService;

    ReaderService(final ReaderRepository readerRepository, final ReaderMapper readerMapper, final BookCopyService copyService) {
        this.readerRepository = readerRepository;
        this.readerMapper = readerMapper;
        this.copyService = copyService;
    }

    ReaderDto createNewReader(ReaderDto readerDto){
        Reader reader = readerMapper.mapToReader(readerDto);
        readerRepository.save(reader);
        return readerMapper.mapToReaderDto(reader);
    }

    public void rentABook(BookCopy bookCopy, Long readerId) throws ReaderNotFoundException {
        if (!readerRepository.existsById(readerId))
            throw new ReaderNotFoundException();
        Reader reader = readerRepository.findById(readerId).orElseThrow(ReaderNotFoundException::new);
        reader.getBookCopies().add(bookCopy);
        readerRepository.save(reader);
    }

    public void returnABook(Long readerId, Long copiesId) throws ReaderNotFoundException, CopiesNotFoundException {
        if (!readerRepository.existsById(readerId))
            throw new ReaderNotFoundException();
        copyService.returnABook(copiesId);
        Reader reader = readerRepository.findById(readerId).orElseThrow(ReaderNotFoundException::new);
        reader.getBookCopies().remove(copyService.copyToDelete(reader,copiesId));
        readerRepository.save(reader);
    }

    public Reader findReader(Long readerId) throws ReaderNotFoundException {
        if (!readerRepository.existsById(readerId))
            throw new ReaderNotFoundException();
        return readerRepository.findById(readerId).orElseThrow(ReaderNotFoundException::new);
    }

    public void saveReader(Reader reader){
        readerRepository.save(reader);
    }
}
