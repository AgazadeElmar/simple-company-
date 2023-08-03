package com.example.imtahaaaaan.mapper;

import com.example.imtahaaaaan.dto.UsersDto;
import com.example.imtahaaaaan.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsersMapper {


    UsersDto userstoDto(Users users);

    Users usersDtoToEntity(UsersDto usersDto);
}
