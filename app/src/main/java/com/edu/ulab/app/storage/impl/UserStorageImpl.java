package com.edu.ulab.app.storage.impl;

import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.entity.Book;
import com.edu.ulab.app.entity.User;
import com.edu.ulab.app.storage.UserStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserStorageImpl implements UserStorage {

    private List<User> users = new ArrayList<>();

    @Override
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        var foundUser =  users.stream()
                .filter(user1 -> user1.getId().equals(user.getId()))
                .findFirst()
                .orElse(null);

        users.removeIf(user1 -> user1.getId().equals(user.getId()));
        users.add(user);

        return user;
    }

    @Override
    public User getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteUserById(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    @Override
    public User getUserByName(String name) {
        return users.stream()
                .filter(user -> user.getFullName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
