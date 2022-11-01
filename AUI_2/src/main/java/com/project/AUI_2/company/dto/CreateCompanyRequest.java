package com.project.AUI_2.company.dto;


import com.project.AUI_2.company.entity.Company;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.function.Function;

@Builder
@ToString
@Getter
public class CreateCompanyRequest {

    private String name;

    private int age;

    public static Function<CreateCompanyRequest, Company>dtoToEntityMapper(){
        return request -> Company.builder().name(request.getName()).age(request.getAge()).build();
    }
}
