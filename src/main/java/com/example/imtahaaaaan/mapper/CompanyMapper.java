package com.example.imtahaaaaan.mapper;

import com.example.imtahaaaaan.dto.CompanyDto;
import com.example.imtahaaaaan.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompanyMapper {


    CompanyDto companyToDto(Company company);

    Company companyDtoToEntity(CompanyDto companyDto);
}
