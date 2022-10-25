package com.project.AUI_2.datastore;

import com.project.AUI_2.company.entity.Company;
import com.project.AUI_2.worker.entity.Worker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataStore {
    public List<Worker> workerList = new ArrayList<>();
    public List<Company> companyList = new ArrayList<>();
}
