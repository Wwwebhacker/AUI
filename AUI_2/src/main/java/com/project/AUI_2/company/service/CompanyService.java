package com.project.AUI_2.company.service;

import com.project.AUI_2.company.entity.Company;
import com.project.AUI_2.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository repository;

    @Autowired
    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public List<Company> findAll() {
        return repository.findAll();
    }

    public Optional<Company> find(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void create(Company company) {
        repository.save(company);
    }

    @Transactional
    public void delete(Long company) {
        repository.deleteById(company);
    }

    @Transactional
    public void update(Company company) {
        repository.save(company);
    }
}
