package com.project.AUI_2.company.controller;

import com.project.AUI_2.company.dto.CreateCompanyRequest;
import com.project.AUI_2.company.dto.GetCompaniesResponse;
import com.project.AUI_2.company.dto.GetCompanyResponse;
import com.project.AUI_2.company.dto.UpdateCompanyRequest;
import com.project.AUI_2.company.entity.Company;
import com.project.AUI_2.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
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
    public ResponseEntity<GetCompanyResponse> getCompany(@PathVariable("id") long id) {
        return companyService.find(id).map(value -> ResponseEntity.ok(GetCompanyResponse.entityToDtoMapper().apply(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createCompany(@RequestBody CreateCompanyRequest request, UriComponentsBuilder builder) {
        Company company = CreateCompanyRequest.dtoToEntityMapper().apply(request);
        company = companyService.create(company);

        return ResponseEntity.created(builder.pathSegment("api", "companies", "{id}").buildAndExpand(company.getId()).toUri()).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateCompany(@RequestBody UpdateCompanyRequest request, @PathVariable("id") long id) {
        Optional<Company> companyOptional = companyService.find(id);
        if (companyOptional.isPresent()) {
            UpdateCompanyRequest.dtoToEntityUpdater().apply(companyOptional.get(), request);
            companyService.update(companyOptional.get());

            return ResponseEntity.accepted().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable("id") long id) {
        Optional<Company> companyOptional = companyService.find(id);
        if (companyOptional.isPresent()) {
            companyService.delete(companyOptional.get().getId());

            return ResponseEntity.accepted().build();
        }

        return ResponseEntity.notFound().build();
    }
}
