package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUser(Long id);

    String delete(Long id);

    String createUser(UserDto userDto);

    String updateUser(UserDto userDto);

    User getUserByEmail(String email);
}
