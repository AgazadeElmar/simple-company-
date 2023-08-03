package com.example.imtahaaaaan.service;

import com.example.imtahaaaaan.dto.UsersDto;

import java.util.List;

public interface UsersService {
    List<UsersDto> readAllUsers();
    UsersDto getUserById(long id);
    void createUser(UsersDto usersDto);
    void userUpdateById(long id,UsersDto usersDto);
    void  userDeleteById(long id);
}
