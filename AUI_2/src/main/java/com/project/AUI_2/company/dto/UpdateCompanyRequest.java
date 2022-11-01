package com.project.AUI_2.company.dto;


import com.project.AUI_2.company.entity.Company;
import lombok.Getter;

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
