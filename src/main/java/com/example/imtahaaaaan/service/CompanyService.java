package com.example.imtahaaaaan.service;

import com.example.imtahaaaaan.dto.CompanyDto;

import java.util.List;

public interface CompanyService {
List<CompanyDto> readAllCompany();
CompanyDto GetCompanyById(long id);
void createCompany(CompanyDto companyDto);
void companyUpdateById(long id,CompanyDto companyDto);
void companyDeleteById(long id);



}
