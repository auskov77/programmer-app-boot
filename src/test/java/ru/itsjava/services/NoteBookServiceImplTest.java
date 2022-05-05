package ru.itsjava.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.itsjava.domain.NoteBook;

@SpringBootTest
//@ComponentScan("ru.itsjava.services")
@DisplayName("Класс NoteBookServiceImpl")
public class NoteBookServiceImplTest {

    @Configuration
    static class MyConfiguration {

        @Bean
        public NoteBookService noteBookService() {
            return new NoteBookServiceImpl("apple", "air", 2022);
        }
    }

    @Autowired
    private NoteBookServiceImpl noteBookService;

    @DisplayName(" должен кооректно давать ноутбук")
    @Test
    public void shouldHaveCorrectMethodGetNoteBook() {
//        NoteBookService noteBookService = new NoteBookServiceImpl("Macbook", "Pro", 2022);
        NoteBook noteBook = noteBookService.getNoteBook();
        Assertions.assertEquals(noteBook.getFirm(), "apple");

    }
}
