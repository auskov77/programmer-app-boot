package ru.itsjava.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsjava.domain.NoteBook;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Класс ProgrammerService")
public class ProgrammerServiceImplTest {

    @Configuration
    static class MyConfiguration {

        @Bean
        public IOService ioService() {
            IOServiceImpl mockIOService = Mockito.mock(IOServiceImpl.class);

            when(mockIOService.input()).thenReturn("vitaliy");

            return mockIOService;
//            return new IOServiceImpl();
        }

        @Bean
        public NoteBookService noteBookService() {
            NoteBookServiceImpl noteNoteBookService = Mockito.mock(NoteBookServiceImpl.class);
            when(noteNoteBookService.getNoteBook()).thenReturn(new NoteBook("Asus", "G115AF", 2010));

            return noteNoteBookService;
        }

        @Bean
        public ProgrammerService programmerService(NoteBookService noteBookService, IOService ioService) {
            return new ProgrammerServiceImpl(noteBookService, ioService);
        }
    }

    @Autowired
    private ProgrammerService programmerService;

    @DisplayName(" корректный метод Привет-программист")
    @Test
    public void shouldHaveCorrectMethodHiToNewProgrammer() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        programmerService.hiToNewProgrammer();

        assertEquals("Enter your name: \n"+
                "Hello vitaliy\n" +
                "Your computer: Notebook{Asus G115AF 2010}\n", out.toString());
    }
}
