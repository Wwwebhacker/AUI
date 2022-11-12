package pg.edu.pg.eti.kask.AUI.worker.dto;

import lombok.Builder;
import lombok.Getter;
import pg.edu.pg.eti.kask.AUI.company.entity.Company;
import pg.edu.pg.eti.kask.AUI.worker.entity.Worker;

import java.util.function.Function;

@Builder
@Getter
public class GetWorkerResponse {
    private Long id;

    private String name;

    private int age;

    public static Function<Worker, GetWorkerResponse> entityToDtoMapper() {
        return worker -> GetWorkerResponse.builder()
                .id(worker.getId())
                .name(worker.getName())
                .age(worker.getAge())
                .build();
    }
}
