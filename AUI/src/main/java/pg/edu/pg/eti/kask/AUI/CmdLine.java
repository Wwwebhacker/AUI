package pg.edu.pg.eti.kask.AUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pg.edu.pg.eti.kask.AUI.company.entity.Company;
import pg.edu.pg.eti.kask.AUI.company.service.CompanyService;
import pg.edu.pg.eti.kask.AUI.worker.entity.Worker;
import pg.edu.pg.eti.kask.AUI.worker.service.WorkerService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class CmdLine implements CommandLineRunner {
    CompanyService companyService;
    WorkerService workerService;
    Scanner in = new Scanner(System.in);

    @Autowired
    public CmdLine(CompanyService companyService, WorkerService workerService) {
        this.companyService = companyService;
        this.workerService = workerService;
    }

    private void createWorker() {

        System.out.println("Name: ");
        String name = in.nextLine();

        System.out.println("Company id: ");
        Long id = Long.parseLong(in.nextLine());
        Optional<Company> company = companyService.find(id);
        if (company.isPresent()) {
            Worker worker = Worker.builder().name(name).company(company.get()).build();
            workerService.create(worker);
            return;
        }
        System.out.println("Error");
    }

    private void deleteWorker() {
        System.out.println("Worker id: ");
        Long id = Long.parseLong(in.nextLine());
        Optional<Worker> worker = workerService.find(id);
        if (worker.isPresent()) {
            workerService.delete(worker.get().getId());
            return;
        }
        System.out.println("Error");
    }

    private <T> void print(List<T> list) {
        for (T t : list) {
            System.out.println(t);
        }
    }

    @Override
    public void run(String... args) throws Exception {

        boolean exit = false;

        while (!exit) {
            String cmd = in.nextLine();
            switch (cmd) {
                case "exit" -> exit = true;
                case "c" -> print(companyService.findAll());
                case "w" -> print(workerService.findAll());
                case "wc" -> createWorker();
                case "wd" -> deleteWorker();
            }
            cmd = "";
        }
    }
}
