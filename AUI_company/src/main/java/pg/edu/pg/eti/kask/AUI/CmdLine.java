package pg.edu.pg.eti.kask.AUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pg.edu.pg.eti.kask.AUI.company.service.CompanyService;

import java.util.List;
import java.util.Scanner;

@Component
public class CmdLine implements CommandLineRunner {
    CompanyService companyService;
    Scanner in = new Scanner(System.in);

    @Autowired
    public CmdLine(CompanyService companyService) {
        this.companyService = companyService;
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
            }
            cmd = "";
        }
    }
}
