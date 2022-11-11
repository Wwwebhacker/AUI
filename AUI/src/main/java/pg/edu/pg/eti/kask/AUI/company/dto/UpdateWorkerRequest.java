package pg.edu.pg.eti.kask.AUI.company.dto;

import lombok.Getter;
import pg.edu.pg.eti.kask.AUI.worker.entity.Worker;

import java.util.function.BiFunction;

@Getter
public class UpdateWorkerRequest {

    private String name;

    public static BiFunction<Worker, UpdateWorkerRequest, Worker> dtoToEntityUpdater() {
        return (worker, updateWorkerRequest) -> {
            worker.setName(updateWorkerRequest.getName());
            return worker;
        };
    }
}
