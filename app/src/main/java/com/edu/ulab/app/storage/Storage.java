package com.edu.ulab.app.storage;

import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.entity.Book;
import com.edu.ulab.app.entity.User;
import com.edu.ulab.app.exception.NotFoundException;
import com.edu.ulab.app.mapper.BookMapper;
import com.edu.ulab.app.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class Storage {
    private final BookStorage bookStorage;
    private final UserStorage userStorage;

    private final BookMapper bookMapper;

    private final UserMapper userMapper;

    public Storage(BookStorage bookStorage, UserStorage userStorage, BookMapper bookMapper, UserMapper userMapper) {
        this.bookStorage = bookStorage;
        this.userStorage = userStorage;
        this.bookMapper = bookMapper;
        this.userMapper = userMapper;
    }

    public BookDto createBook(BookDto bookDto) {
        Book book = bookMapper.bookDtoToBook(bookDto);
        var createdBook = bookStorage.createBook(book);
        return bookMapper.bookToBookDto(createdBook);
    }

    public BookDto updateBook(BookDto bookDto) {
        Book book = bookMapper.bookDtoToBook(bookDto);
        var createdBook = bookStorage.updateBook(book);
        return bookMapper.bookToBookDto(createdBook);
    }

    public BookDto getBookById(Long id) {
        var foundBook = bookStorage.getBookById(id);
        if (foundBook == null) {
            throw new NotFoundException("book with this id not found");
        }
        return bookMapper.bookToBookDto(foundBook);
    }

    public void deleteBookById(Long id) {
        bookStorage.deleteBookById(id);
    }

    public UserDto createUser(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        var createdUser = userStorage.createUser(user);
        return userMapper.userToUserDto(createdUser);
    }

    public UserDto updateUser(UserDto userDto) {
        var foundUser = userStorage.getUserByName(userDto.getFullName());
        if (foundUser == null) {
            throw new NotFoundException("user with this id not found");
        }

        return userMapper.userToUserDto(userStorage.updateUser(foundUser));
    }

    public UserDto getUserById(Long id) {
        var foundUser = userStorage.getUserById(id);
        if (foundUser == null) {
            throw new NotFoundException("user with this id not found");
        }

        return userMapper.userToUserDto(foundUser);
    }

    public void deleteUserById(Long id) {
        userStorage.deleteUserById(id);
    }

    public List<BookDto> getBooksByUserId(Long userId) {
        return bookStorage
                .getBooksByUserId(userId).stream()
                .filter(Objects::nonNull)
                .map(bookMapper::bookToBookDto)
                .toList();
    }

    public void deleteBookByUserId(Long userId) {
        bookStorage.deleteBookByUserId(userId);
    }

    public UserDto getUserByName(String name) {
        var foundUser = userStorage.getUserByName(name);
        return userMapper.userToUserDto(foundUser);
    }

    public void setBooksToUser(List<BookDto> bookDtos) {
        List<Book> books = bookDtos.stream()
                .map(bookMapper::bookDtoToBook)
                .toList();

        bookStorage.setBooksToUser(books);
    }

    //todo создать хранилище в котором будут содержаться данные
    // сделать абстракции через которые можно будет производить операции с хранилищем
    // продумать логику поиска и сохранения
    // продумать возможные ошибки
    // учесть, что при сохранеии юзера или книги, должен генерироваться идентификатор
    // продумать что у узера может быть много книг и нужно создать эту связь
    // так же учесть, что методы хранилища принимают друго тип данных - учесть это в абстракции
}
