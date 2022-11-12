package pg.edu.pg.eti.kask.AUI.company.dto;

import lombok.Builder;
import lombok.Getter;
import pg.edu.pg.eti.kask.AUI.worker.entity.Worker;

import java.util.function.Function;

@Builder
@Getter
public class GetCompanyWorkerResponse {
    private Long id;

    private String name;

    private int age;

    public static Function<Worker, GetCompanyWorkerResponse> entityToDtoMapper() {
        return worker -> GetCompanyWorkerResponse.builder()
                .id(worker.getId())
                .name(worker.getName())
                .age(worker.getAge())
                .build();
    }
}
