package com.project.AUI_2.company.dto;


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
public class GetCompanyWorkersResponse {

    @Singular
    private List<GetCompanyWorkersResponse.Worker> workers;

    public static Function<Collection<com.project.AUI_2.worker.entity.Worker>, GetCompanyWorkersResponse> entityToDtoMapper() {
        return workers -> {
            GetCompanyWorkersResponseBuilder response = GetCompanyWorkersResponse.builder();
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
