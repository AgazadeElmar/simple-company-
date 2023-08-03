package com.example.imtahaaaaan.service.Impl;

import com.example.imtahaaaaan.dto.UsersDto;
import com.example.imtahaaaaan.entity.Users;
import com.example.imtahaaaaan.exceptions.NotFoundException;
import com.example.imtahaaaaan.mapper.UsersMapper;
import com.example.imtahaaaaan.repository.UsersRepository;
import com.example.imtahaaaaan.service.UsersService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository repository;
    private final UsersMapper mapper;

    @Override
    public List<UsersDto> readAllUsers() {
        return repository.findAll().stream()
                .map(users -> mapper.userstoDto(users))
                .collect(Collectors.toList());
    }

    @Override
    public UsersDto getUserById(long id) {
        Users users = repository.findById(id).orElseThrow(() -> new NotFoundException("Bu id-li user tapılmadı: " + id));
        return mapper.userstoDto(users);
    }

    @Override
    @Transactional(rollbackOn = {SQLException.class,RuntimeException.class})
    public void createUser(UsersDto usersDto) {
        Users users =mapper.usersDtoToEntity(usersDto);
        try {

            repository.save(users);
        }catch (RuntimeException ex){
            throw new RuntimeException("Save zamani xeta bas verdi",ex);
        }

    }

    @Override
    @Transactional(rollbackOn = {SQLException.class,RuntimeException.class})
    public void userUpdateById(long id, UsersDto usersDto) {
        Users users = repository.findById(id).orElseThrow(() -> new NotFoundException("Belə bir User tapılmadı :( "));

        users.setFirstName(usersDto.getFirstName());
        users.setLastName(usersDto.getLastName());
        users.setBirthdate(usersDto.getBirthdate());
        users.setPassword(usersDto.getPassword());
        users.setEmail(usersDto.getEmail());

        try {

            repository.save(users);
        } catch (Exception ex) {
            throw new RuntimeException("Update etmek mümkün olmadı : " + id, ex);
        }

    }

    @Override
    @Transactional(rollbackOn = {SQLException.class,RuntimeException.class})
    public void userDeleteById(long id) {
        if (repository.existsById(id)) {

            try {

                repository.deleteById(id);
            } catch (RuntimeException ex) {
                throw new RuntimeException("Useri silmek mumkun olmadi : " + id, ex);
            }
        } else throw new NotFoundException("Bu id-li User tapılmadı: " + id);

    }
}
