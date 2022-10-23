package com.example.demo.service;

import com.example.demo.entity.Company;
import com.example.demo.entity.Worker;
import com.example.demo.repository.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class CompanyService {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Worker find(Integer id){
        return companyRepository.find(id);
    }

    public void create(Company company){
        companyRepository.create(worker);
    }

    public void delete(Worker worker){
        companyRepository.delete(worker);
    }

    public void update(Worker worker){
        companyRepository.update(worker);
    }
}
