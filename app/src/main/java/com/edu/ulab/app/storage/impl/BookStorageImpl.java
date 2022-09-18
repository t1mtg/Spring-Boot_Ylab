package com.edu.ulab.app.storage.impl;

import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.entity.Book;
import com.edu.ulab.app.storage.BookStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookStorageImpl implements BookStorage {

    private final List<Book> books = new ArrayList<>();

    @Override
    public Book createBook(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        books.removeIf(book1 -> book1.getId().equals(book.getId()));
        books.add(book);
        return book;
    }

    @Override
    public Book getBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteBookById(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    @Override
    public List<Book> getBooksByUserId(Long userId) {
        return books.stream()
                .filter(book -> book.getUserId().equals(userId))
                .toList();
    }

    @Override
    public void deleteBookByUserId(Long userId) {
        books.removeIf(book -> book.getId().equals(userId));
    }

    @Override
    public void setBooksToUser(List<Book> newBooks) {
        books.addAll(newBooks);
    }

}
