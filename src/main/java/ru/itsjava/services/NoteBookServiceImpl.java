package ru.itsjava.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.itsjava.domain.NoteBook;

@Service
//@RequiredArgsConstructor
public class NoteBookServiceImpl implements NoteBookService{
    private final String firm;
    private final String model;
    private final int year;

    public NoteBookServiceImpl(@Value("${notebook.firm}") String firm,
                               @Value("${notebook.model}") String model,
                               @Value("${notebook.year}") int year) {
        this.firm = firm;
        this.model = model;
        this.year = year;
    }

    @Override
    public NoteBook getNoteBook() {
        return new NoteBook(firm, model, year);
    }
}
