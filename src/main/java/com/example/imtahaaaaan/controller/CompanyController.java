package com.example.imtahaaaaan.controller;

import com.example.imtahaaaaan.dto.CompanyDto;
import com.example.imtahaaaaan.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/companys")
public class CompanyController {
    private final CompanyService companyService;
@GetMapping
    public ResponseEntity<List<CompanyDto>> readAllCompany(){
    return ResponseEntity.ok(companyService.readAllCompany());
}
@GetMapping("/{id}")
    public ResponseEntity<CompanyDto> GetCompanyById(@PathVariable long id){
    return ResponseEntity.ok(companyService.GetCompanyById(id));
}
@PostMapping
    public ResponseEntity createCompany(@RequestBody CompanyDto companyDto){
    companyService.createCompany(companyDto);
    return ResponseEntity.ok(HttpStatus.CREATED);
}
@PutMapping("/{id}")
    public ResponseEntity<HttpStatusCode> companyUpdateById(@PathVariable long id, @RequestBody CompanyDto companyDto){
    companyService.companyUpdateById(id,companyDto);
    return ResponseEntity.ok(HttpStatus.OK);
}
@DeleteMapping("/{id}")
    public ResponseEntity companyDeleteById(@PathVariable long id){
    companyService.companyDeleteById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
}
}
