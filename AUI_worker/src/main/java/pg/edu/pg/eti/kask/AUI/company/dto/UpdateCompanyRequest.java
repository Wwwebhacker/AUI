package pg.edu.pg.eti.kask.AUI.company.dto;


import lombok.Getter;
import pg.edu.pg.eti.kask.AUI.company.entity.Company;

import java.util.function.BiFunction;

@Getter
public class UpdateCompanyRequest {

    private String name;

    public static BiFunction<Company, UpdateCompanyRequest, Company> dtoToEntityUpdater() {
        return ((company, updateCompanyRequest) -> {
            company.setName(updateCompanyRequest.getName());
            return company;
        });
    }
}
