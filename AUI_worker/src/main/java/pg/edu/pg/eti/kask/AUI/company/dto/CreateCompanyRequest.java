package pg.edu.pg.eti.kask.AUI.company.dto;


import lombok.*;
import pg.edu.pg.eti.kask.AUI.company.entity.Company;

import java.util.function.Function;

@Builder
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyRequest {

    private long id;


    public static Function<CreateCompanyRequest, Company> dtoToEntityMapper() {
        return request -> Company.builder().id(request.getId()).build();
    }
}
