package pg.edu.pg.eti.kask.AUI.seeder;

import org.springframework.stereotype.Component;
import pg.edu.pg.eti.kask.AUI.company.entity.Company;
import pg.edu.pg.eti.kask.AUI.company.service.CompanyService;
import pg.edu.pg.eti.kask.AUI.worker.entity.Worker;
import pg.edu.pg.eti.kask.AUI.worker.service.WorkerService;

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
        Company company1 = Company.builder().name("Company").build();
        Company company2 = Company.builder().name("Company").build();
        System.out.println(company1);
        System.out.println(company2);
        companyService.create(company1);
        companyService.create(company2);

        Worker worker1 = Worker.builder().name("worker").company(company1).build();
        Worker worker2 = Worker.builder().name("worker").company(company1).build();
        Worker worker3 = Worker.builder().name("worker").company(company2).build();
        Worker worker4 = Worker.builder().name("worker").company(company2).build();

        workerService.create(worker1);
        workerService.create(worker2);
        workerService.create(worker3);
        workerService.create(worker4);


    }
}
