package com.crud.kodillalibrary;

import com.crud.kodillalibrary.main.Book;
import com.crud.kodillalibrary.main.CopyBook;
import com.crud.kodillalibrary.main.dao.CopyBookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class KodillaLibraryApplicationTests {

    @Autowired
    private CopyBookDao copyBookDao;
    private Book book;
    @Test
    void test1(){
        //Given
        CopyBook copyBook = new CopyBook("Magazine");
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
        CopyBook copyBook = new CopyBook("magazine");
        copyBook.setBook(new Book(1993,"testes title","test"));
        //When
        copyBookDao.save(copyBook);
        Long id = copyBook.getId();
        List<CopyBook> resultList = copyBookDao.findByStatus("magazine");
        //Then
        assertEquals(1,resultList.size());
        assertNotEquals(1,id);

        //CleanUp
        //copyBookDao.deleteById(id);
    }


    @Test
    void contextLoads() {
    }

}
