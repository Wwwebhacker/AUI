package com.project.AUI_2.company.controller;

import com.project.AUI_2.company.dto.GetCompaniesResponse;
import com.project.AUI_2.company.dto.GetCompanyResponse;
import com.project.AUI_2.company.entity.Company;
import com.project.AUI_2.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("api/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<GetCompaniesResponse> getCompanies() {
        List<Company> all = companyService.findAll();
        Function<Collection<Company>, GetCompaniesResponse> mapper = GetCompaniesResponse.entityToDtoMapper();
        GetCompaniesResponse response = mapper.apply(all);

        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<GetCompanyResponse> getCompany(@PathVariable("id") long id){
        return companyService.find(id).map(value -> ResponseEntity.ok(GetCompanyResponse.entityToDtoMapper().apply(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
