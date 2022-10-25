package com.project.AUI_2.company.dto;

import com.project.AUI_2.company.entity.Company;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Builder
@ToString
@Getter
public class GetCompaniesResponse {

    @Builder
    @Getter
    @ToString
    public static class Company{

        private Long id;

        private String name;
    }

    @Singular
    private List<Company> companies;

    public static Function<Collection<com.project.AUI_2.company.entity.Company>, GetCompaniesResponse> entityToDtoMapper() {
        return companies -> {
            GetCompaniesResponseBuilder response = GetCompaniesResponse.builder();
            companies.stream()
                    .map(company -> Company.builder()
                            .id(company.getId())
                            .name(company.getName())
                            .build())
                    .forEach(response::company);
            return response.build();
        };
    }
}
