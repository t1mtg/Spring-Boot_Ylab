package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.entity.Book;
import com.edu.ulab.app.service.BookService;
import com.edu.ulab.app.storage.Storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class BookServiceImpl implements BookService {
    private final Storage storage;

    public BookServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        bookDto.setId(id);
        return storage.createBook(bookDto);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        return null;
    }

    @Override
    public BookDto getBookById(Long id) {
        return storage.getBookById(id);
    }

    @Override
    public void deleteBookById(Long id) {
        storage.deleteBookById(id);
    }

    @Override
    public List<BookDto> getBooksByUserId(Long userId) {
        return storage.getBooksByUserId(userId);
    }

    @Override
    public void deleteBookByUserId(Long userId) {
        storage.deleteBookByUserId(userId);
    }

    @Override
    public void setBooksToUser(List<BookDto> bookDtos) {
        storage.setBooksToUser(bookDtos);
    }
}
