package pg.edu.pg.eti.kask.AUI.company.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import pg.edu.pg.eti.kask.AUI.company.entity.Company;

import java.util.function.Function;

@Builder
@ToString
@Getter
public class CreateCompanyRequest {

    private String name;

    private int age;

    public static Function<CreateCompanyRequest, Company> dtoToEntityMapper() {
        return request -> Company.builder().name(request.getName()).age(request.getAge()).build();
    }
}
