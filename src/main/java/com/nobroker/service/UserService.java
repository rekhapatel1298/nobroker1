package com.nobroker.service;

import com.nobroker.entity.User;
import com.nobroker.payload.UserDto;

import java.util.List;

public interface UserService {

    long createUser(UserDto userDto);


    User getUserByEmail(String email);

    void verifyEmail(User user);

    boolean isEmailVerified(String email);

    User registerUser(User user);

    User getUserById(long id);

    List<User> getAllUser();
}
