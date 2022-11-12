package pg.edu.pg.eti.kask.AUI.company.event.dto;

import lombok.Builder;
import lombok.Getter;
import pg.edu.pg.eti.kask.AUI.company.entity.Company;

import java.util.function.Function;

@Getter
@Builder
public class CreateCompanyRequest {

    private Long id;

    public static Function<Company, CreateCompanyRequest> entityToDtoMapper(){
    return entity -> CreateCompanyRequest.builder().id(entity.getId()).build();
}
}
