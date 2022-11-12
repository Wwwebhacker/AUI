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
        this.workerService = workerService;
        this.companyService = companyService;
    }

    @PostConstruct
    private void init() {

        Worker worker1 = Worker.builder().name("worker").build();
        Worker worker2 = Worker.builder().name("worker").build();
        Worker worker3 = Worker.builder().name("worker").build();
        Worker worker4 = Worker.builder().name("worker").build();

        workerService.create(worker1);
        workerService.create(worker2);
        workerService.create(worker3);
        workerService.create(worker4);


    }
}
