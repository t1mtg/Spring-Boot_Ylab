package com.edu.ulab.app.storage;

import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.entity.Book;

import java.util.List;

public interface BookStorage {

    Book createBook(Book book);

    Book updateBook(Book book);

    Book getBookById(Long id);

    void deleteBookById(Long id);

    List<Book> getBooksByUserId(Long userId);

    void deleteBookByUserId(Long userId);

    void setBooksToUser(List<Book> books);
}
