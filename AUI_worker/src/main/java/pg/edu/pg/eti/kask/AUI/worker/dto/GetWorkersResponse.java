package pg.edu.pg.eti.kask.AUI.worker.dto;


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
public class GetWorkersResponse {

    @Singular
    private List<GetWorkersResponse.Worker> workers;

    public static Function<Collection<pg.edu.pg.eti.kask.AUI.worker.entity.Worker>, GetWorkersResponse> entityToDtoMapper() {
        return workers -> {
            GetWorkersResponseBuilder response = GetWorkersResponse.builder();
            workers.stream().map(
                    worker -> Worker.builder()
                            .id(worker.getId())
                            .name(worker.getName())
                            .build()
            ).forEach(response::worker);
            return response.build();
        };
    }

    @Builder
    @Getter
    @ToString
    public static class Worker {
        private Long id;

        private String name;
    }
}
