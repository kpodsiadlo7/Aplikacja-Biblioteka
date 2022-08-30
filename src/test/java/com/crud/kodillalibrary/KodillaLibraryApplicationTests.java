package com.crud.kodillalibrary;

import com.crud.kodillalibrary.main.Book;
import com.crud.kodillalibrary.main.CopyBook;
import com.crud.kodillalibrary.main.Readers;
import com.crud.kodillalibrary.main.Rental;
import com.crud.kodillalibrary.main.dao.BookDao;
import com.crud.kodillalibrary.main.dao.CopyBookDao;
import com.crud.kodillalibrary.main.dao.ReadersDao;
import com.crud.kodillalibrary.main.dao.RentalDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class KodillaLibraryApplicationTests {

    @Autowired
    private CopyBookDao copyBookDao;
    @Autowired
    private RentalDao rentalDao;
    @Autowired
    private ReadersDao readersDao;
    @Autowired
    private BookDao bookDao;

    @Test
    void test1(){
        //Given
        CopyBook copyBook = new CopyBook("Magazine",33);
        copyBookDao.save(copyBook);
        Long id = copyBook.getId();
        //When
        List<CopyBook> resultList = copyBookDao.findByStatus("Magazine");
        //Then
        assertEquals(1,resultList.size());

        //CleanUp
        copyBookDao.deleteById(id);
    }

    @Test
    void test2(){
        //Given
        CopyBook copyBook = new CopyBook("magazine",13);
        copyBook.setBook(new Book(1993,"testes title","test"));
        //When
        copyBookDao.save(copyBook);
        Long id = copyBook.getId();
        List<CopyBook> resultList = copyBookDao.findByStatus("magazine");
        //Then
        assertEquals(1,resultList.size());
        assertNotEquals(1,id);

        //CleanUp
        copyBookDao.deleteById(id);
    }

    @Test
    void test3(){
        //Given
        Readers reader1 = new Readers("tested name","TestSurname");
        CopyBook book1 = new CopyBook("DAMAGED",32);
        book1.setBook(new Book(2015,"Tilte TEST","author"));
        Rental rental = new Rental(new Date());
        rental.setReaders(reader1);
        rental.setCopyBook(book1);
        copyBookDao.save(book1);
        readersDao.save(reader1);
        rentalDao.save(rental);
        //When
        List<CopyBook> status = copyBookDao.findByStatus("DAMAGED");
        int damaged = status.size();
        List<Readers> reader = readersDao.findByReaderName("tested name");
        Long id = rental.getId();
        //Then
        assertNotEquals(1,id);
        assertEquals(damaged,status.size());
        assertNotEquals(0,reader.size());

        //CleanUp
        //copyBookDao.deleteAll();
        //readersDao.deleteAll();
        rentalDao.deleteAll();

    }


    @Test
    void contextLoads() {
    }

}
