package com.edu.ulab.app.service;


import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.entity.Book;

import java.util.List;

public interface BookService {
    BookDto createBook(BookDto userDto);

    BookDto updateBook(BookDto userDto);

    BookDto getBookById(Long id);

    void deleteBookById(Long id);

    List<BookDto> getBooksByUserId(Long userId);

    void deleteBookByUserId(Long userId);

    void setBooksToUser(List<BookDto> bookDtos);
}
