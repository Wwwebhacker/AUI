package com.project.AUI_1.company.service;

import com.project.AUI_1.company.entity.Company;
import com.project.AUI_1.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company find(int id) {
        return companyRepository.find(id);
    }

    public void create(Company company) {
        companyRepository.create(company);
    }

    public void delete(Company company) {
        companyRepository.delete(company);
    }

    public void update(Company company) {
        companyRepository.update(company);
    }
}
