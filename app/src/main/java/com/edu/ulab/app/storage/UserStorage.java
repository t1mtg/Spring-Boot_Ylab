package com.edu.ulab.app.storage;

import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.entity.Book;
import com.edu.ulab.app.entity.User;

import java.util.List;

public interface UserStorage {
    
    User createUser(User user);

    User updateUser(User user);

    User getUserById(Long id);
    
    void deleteUserById(Long id);
    User getUserByName(String name);
}
