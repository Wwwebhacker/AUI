package com.project.AUI_1.company.repository;

import com.project.AUI_1.company.entity.Company;
import com.project.AUI_1.datastore.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyRepository {
    private final DataStore dataStore;
    private int id = 0;

    @Autowired
    public CompanyRepository(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public List<Company> findAll() {
        return new ArrayList<>(dataStore.companyList);
    }

    public void create(Company entity) {
        entity.setId(id++);
        dataStore.companyList.add(entity);
    }

    public Company find(int id) {
        for (Company company : dataStore.companyList) {
            if (company.getId() == id) {
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
