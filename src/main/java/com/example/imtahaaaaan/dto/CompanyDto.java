package com.example.imtahaaaaan.dto;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CompanyDto {
    private Long id;
    private String name;
    private LocalDate createDate;

}
