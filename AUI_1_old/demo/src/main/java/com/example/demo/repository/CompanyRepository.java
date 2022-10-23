package com.example.demo.repository;

import com.example.demo.datastore.DataStore;
import com.example.demo.entity.Company;
import com.example.demo.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyRepository {

    private final DataStore dataStore;

    @Autowired
    public CompanyRepository(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public List<Company> findAll() {
        return new ArrayList<>(dataStore.companyList);
    }
    public void create(Company entity) {
        dataStore.companyList.add(entity);
    }
    public Company find(Integer id) {
        for (Company company : dataStore.companyList){
            if (company.getId().equals(id)){
                return company;
            }
        }
        return null;
    }
    public void update(Company entity) {
        Company company = this.find(entity.getId());
        delete(company);
        create(entity);
    }
    public void delete(Company entity) {
        dataStore.companyList.remove(entity);
    }
}
