package com.project.AUI_2.company.dto;

import com.project.AUI_2.company.entity.Company;
import com.project.AUI_2.worker.entity.Worker;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

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
    ){

        return createWorkerRequest -> Worker.builder()
                .name(createWorkerRequest.getName())
                .age(createWorkerRequest.getAge())
                .company(companySupplier.get())
                .build();
    }
}
