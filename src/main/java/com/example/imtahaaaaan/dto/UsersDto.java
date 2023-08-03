package com.example.imtahaaaaan.dto;

import com.example.imtahaaaaan.entity.Company;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UsersDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String password;

    private LocalDate birthdate;
    private String email;


}
