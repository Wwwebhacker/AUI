package com.project.AUI_2.company.dto;

import com.project.AUI_2.worker.entity.Worker;
import lombok.Getter;

import java.util.function.BiFunction;
import java.util.function.Function;

@Getter
public class UpdateWorkerRequest {

    private String name;

    public static BiFunction<Worker,UpdateWorkerRequest,Worker> dtoToEntityUpdater(){
        return (worker, updateWorkerRequest) -> {
            worker.setName(updateWorkerRequest.getName());
            return worker;
        };
    }
}
