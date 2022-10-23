package com.project.AUI_1.datastore;

import com.project.AUI_1.company.entity.Company;
import com.project.AUI_1.worker.entity.Worker;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataStore {
    public List<Worker> workerList;
    public List<Company> companyList;
}
