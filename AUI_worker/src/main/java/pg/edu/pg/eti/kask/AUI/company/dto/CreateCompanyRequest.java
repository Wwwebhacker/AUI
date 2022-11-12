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

    private long id;


    public static Function<CreateCompanyRequest, Company> dtoToEntityMapper() {
        return request -> Company.builder().id(request.getId()).build();
    }
}
