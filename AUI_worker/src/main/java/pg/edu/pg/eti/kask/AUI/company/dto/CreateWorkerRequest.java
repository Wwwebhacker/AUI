package pg.edu.pg.eti.kask.AUI.company.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import pg.edu.pg.eti.kask.AUI.company.entity.Company;
import pg.edu.pg.eti.kask.AUI.worker.entity.Worker;

import java.util.function.Function;
import java.util.function.Supplier;

@Builder
@ToString
@Getter
public class CreateWorkerRequest {

    private String name;

    private int age;

    public static Function<CreateWorkerRequest, Worker> dtoToEntityMapper(
            Supplier<Company> companySupplier
    ) {

        return createWorkerRequest -> Worker.builder()
                .name(createWorkerRequest.getName())
                .age(createWorkerRequest.getAge())
                .company(companySupplier.get())
                .build();
    }
}
