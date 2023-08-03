package com.example.imtahaaaaan.controller;

import com.example.imtahaaaaan.dto.UsersDto;
import com.example.imtahaaaaan.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UsersController {
    private final UsersService usersService;
    @GetMapping
    public ResponseEntity<List<UsersDto>> readAllUsers(){
        return ResponseEntity.ok(usersService.readAllUsers());
    }
    @GetMapping("{id}")
    public ResponseEntity<UsersDto> userGetById(@PathVariable long id){
        return ResponseEntity.ok(usersService.getUserById(id));
    }
    @PostMapping
    public ResponseEntity createUser(@RequestBody UsersDto usersDto){
        usersService.createUser(usersDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatusCode> userUpdateById(@PathVariable long id, @RequestBody UsersDto usersDto){
        usersService.userUpdateById(id, usersDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity userDeleteById(@PathVariable long id){
        usersService.userDeleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
