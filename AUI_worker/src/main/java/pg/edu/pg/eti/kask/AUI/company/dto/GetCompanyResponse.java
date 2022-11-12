package pg.edu.pg.eti.kask.AUI.company.dto;


import lombok.Builder;
import lombok.Getter;
import pg.edu.pg.eti.kask.AUI.company.entity.Company;

import java.util.function.Function;

@Builder
@Getter
public class GetCompanyResponse {
    private Long id;

    private String name;

    private int age;

    public static Function<Company, GetCompanyResponse> entityToDtoMapper() {
        return company -> GetCompanyResponse.builder()
                .id(company.getId())
                .name(company.getName())
                .age(company.getAge())
                .build();
    }
}
