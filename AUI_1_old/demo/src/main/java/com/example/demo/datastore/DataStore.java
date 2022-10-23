package com.example.demo.datastore;

import com.example.demo.entity.Company;
import com.example.demo.entity.Worker;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataStore {
    public List<Worker> workerList;
    public List<Company> companyList;
}
