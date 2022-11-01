package com.project.AUI_2.company.dto;

import com.project.AUI_2.worker.entity.Worker;
import lombok.Builder;
import lombok.Getter;

import java.util.function.Function;

@Builder
@Getter
public class GetCompanyWorkerResponse {
    private Long id;

    private String name;

    private int age;

    public static Function<Worker, GetCompanyWorkerResponse> entityToDtoMapper(){
        return worker -> GetCompanyWorkerResponse.builder()
                .id(worker.getId())
                .name(worker.getName())
                .age(worker.getAge())
                .build();
    }
}
