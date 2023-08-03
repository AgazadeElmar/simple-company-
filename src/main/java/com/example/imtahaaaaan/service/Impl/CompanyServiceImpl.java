package com.example.imtahaaaaan.service.Impl;

import com.example.imtahaaaaan.dto.CompanyDto;
import com.example.imtahaaaaan.entity.Company;
import com.example.imtahaaaaan.exceptions.NotFoundException;
import com.example.imtahaaaaan.mapper.CompanyMapper;
import com.example.imtahaaaaan.repository.CompanyRepository;
import com.example.imtahaaaaan.service.CompanyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;
    private final CompanyMapper mapper;

    @Override
    public List<CompanyDto> readAllCompany() {
        return repository.findAll()
                .stream()
                .map(company -> mapper.companyToDto(company))
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDto GetCompanyById(long id) {
        Company company=repository.findById(id).orElseThrow(() -> new NotFoundException("Bele ID-li company tapilmadi: "+id));
        return mapper.companyToDto(company);
    }

    @Override
    @Transactional(rollbackOn = {SQLException.class,RuntimeException.class})
    public void createCompany(CompanyDto companyDto) {
        Company company=mapper.companyDtoToEntity(companyDto);
        try {
            repository.save(company);
        }catch (RuntimeException ex){
throw new RuntimeException("Save zamani xeta bas verdi",ex);
        }

    }

    @Override
    @Transactional(rollbackOn = {SQLException.class,RuntimeException.class})
    public void companyUpdateById(long id, CompanyDto companyDto) {
Company company=repository.findById(id).orElseThrow(()->new NotFoundException("Bele bir ID-li company tapilmadi: "+ id));
    company.setName(companyDto.getName());
    company.setCreateDate(companyDto.getCreateDate());
     try {
         repository.save(company);
     }catch (RuntimeException ex){
         throw new RuntimeException("Update zamani xeta bas verdi");
     }

    }

    @Override
    @Transactional(rollbackOn = {SQLException.class,RuntimeException.class})
    public void companyDeleteById(long id) {
        if (repository.existsById(id)) {

            try {

                repository.deleteById(id);
            } catch (RuntimeException ex) {
                throw new RuntimeException("Company-ni silmek mumkun olmadi : " + id, ex);
            }
        } else throw new NotFoundException("Bu id-li Company tapılmadı: " + id);

    }


}
