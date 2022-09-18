package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.service.UserService;
import com.edu.ulab.app.storage.Storage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final Storage storage;

    public UserServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        Long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        userDto.setId(id);
        return storage.createUser(userDto);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return storage.updateUser(userDto);
    }

    @Override
    public UserDto getUserById(Long id) {
        return storage.getUserById(id);
    }

    @Override
    public UserDto getUserByName(String name) {
        return storage.getUserByName(name);
    }

    @Override
    public void deleteUserById(Long id) {
        storage.deleteUserById(id);
    }
}
