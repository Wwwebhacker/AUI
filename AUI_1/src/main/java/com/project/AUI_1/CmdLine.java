package com.project.AUI_1;

import com.project.AUI_1.company.entity.Company;
import com.project.AUI_1.company.service.CompanyService;
import com.project.AUI_1.worker.entity.Worker;
import com.project.AUI_1.worker.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
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

    private void createWorker(){

        System.out.println("Name: ");
        String name = in.nextLine();

        print(companyService.findAll());
        System.out.println("Company id: ");
        int id = Integer.parseInt(in.nextLine());
        Company company = companyService.find(id);
        if (company != null){
            Worker worker = Worker.builder().name(name).company(company).create();
            workerService.create(worker);
            return;
        }
        System.out.println("Error");
    }

    private void deleteWorker(){
        print(workerService.findAll());
        System.out.println("Worker id: ");
        int id = Integer.parseInt(in.nextLine());
        Worker worker = workerService.find(id);
        if (worker != null){
            workerService.delete(worker);
            return;
        }
        System.out.println("Error");
    }

    private <T> void print (List<T> list){
        for (T t: list){
            System.out.println(t);
        }
    }

    @Override
    public void run(String... args) throws Exception {

        boolean exit = false;


        System.out.println("x -> exit");
        System.out.println("c -> companies");
        System.out.println("w -> workers");
        System.out.println("wc -> create worker");
        System.out.println("wd -> delete worker");
        while (!exit){
            String cmd = in.nextLine();
            switch (cmd) {
                case "x" -> exit = true;
                case "c" -> print(companyService.findAll());
                case "w" -> print(workerService.findAll());
                case "wc" -> createWorker();
                case "wd" -> deleteWorker();
            }
            cmd = "";
        }
    }
}
