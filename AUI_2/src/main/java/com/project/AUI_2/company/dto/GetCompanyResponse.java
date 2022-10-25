package com.project.AUI_2.company.dto;


import com.project.AUI_2.company.entity.Company;
import lombok.Builder;
import lombok.Getter;

import java.util.function.Function;

@Builder
@Getter
public class GetCompanyResponse {
    private Long id;

    private String name;

    private int age;

    public static Function<Company,GetCompanyResponse> entityToDtoMapper(){
        return company -> GetCompanyResponse.builder()
                .id(company.getId())
                .name(company.getName())
                .age(company.getAge())
                .build();
    }
}
