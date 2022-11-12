package pg.edu.pg.eti.kask.AUI.seeder;

import org.springframework.stereotype.Component;
import pg.edu.pg.eti.kask.AUI.company.entity.Company;
import pg.edu.pg.eti.kask.AUI.company.service.CompanyService;

import javax.annotation.PostConstruct;

@Component
public class InitData {

    private final CompanyService companyService;

    InitData(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostConstruct
    private void init() {
        Company company1 = Company.builder().name("Company").build();
        Company company2 = Company.builder().name("Company").build();
        System.out.println(company1);
        System.out.println(company2);
        companyService.create(company1);
        companyService.create(company2);


    }
}
