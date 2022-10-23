package com.project.AUI_1.seeder;

import com.project.AUI_1.company.entity.Company;
import com.project.AUI_1.company.service.CompanyService;
import com.project.AUI_1.worker.entity.Worker;
import com.project.AUI_1.worker.service.WorkerService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitData {

    private final WorkerService workerService;
    private final CompanyService companyService;

    InitData(WorkerService workerService, CompanyService companyService) {
        this.companyService = companyService;
        this.workerService = workerService;
    }

    @PostConstruct
    private void init() {
        Company company1 = Company.builder().name("Company").create();
        Company company2 = Company.builder().name("Company").create();
        companyService.create(company1);
        companyService.create(company2);

        Worker worker1 = Worker.builder().name("worker").company(company1).create();
        Worker worker2 = Worker.builder().name("worker").company(company1).create();
        Worker worker3 = Worker.builder().name("worker").company(company2).create();
        Worker worker4 = Worker.builder().name("worker").company(company2).create();

        workerService.create(worker1);
        workerService.create(worker2);
        workerService.create(worker3);
        workerService.create(worker4);


    }
}
