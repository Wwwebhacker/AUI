package pg.edu.pg.eti.kask.AUI.worker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pg.edu.pg.eti.kask.AUI.worker.dto.CreateWorkerRequest;
import pg.edu.pg.eti.kask.AUI.worker.dto.GetWorkerResponse;
import pg.edu.pg.eti.kask.AUI.worker.dto.GetWorkersResponse;
import pg.edu.pg.eti.kask.AUI.worker.dto.UpdateWorkerRequest;
import pg.edu.pg.eti.kask.AUI.worker.entity.Worker;
import pg.edu.pg.eti.kask.AUI.worker.service.WorkerService;

import java.util.Optional;

@RestController
@RequestMapping("api/workers")
public class WorkerController {

    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping
    public ResponseEntity<GetWorkersResponse> getWorkers() {
        return ResponseEntity.ok(GetWorkersResponse.entityToDtoMapper().apply(workerService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<GetWorkerResponse> getWorker(@PathVariable("id") long id) {
        return workerService.find(id)
                .map(value -> ResponseEntity.ok(GetWorkerResponse.entityToDtoMapper().apply(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createWorker(@RequestBody CreateWorkerRequest request, UriComponentsBuilder builder) {
        Worker worker = CreateWorkerRequest.dtoToEntityMapper(() -> null).apply(request);
        worker = workerService.create(worker);
        return ResponseEntity.created(builder.pathSegment("api", "workers", "{id}").buildAndExpand(worker.getId()).toUri()).build();
    }

    @PutMapping({"{id}"})
    public ResponseEntity<Void> updateWorker(@RequestBody UpdateWorkerRequest request, @PathVariable("id") long id) {
        Optional<Worker> workerOptional = workerService.find(id);

        if (workerOptional.isPresent()) {
            UpdateWorkerRequest.dtoToEntityUpdater().apply(workerOptional.get(), request);
            workerService.update(workerOptional.get());
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteWorker(@PathVariable("id") long id){
        Optional<Worker> workerOptional = workerService.find(id);
        if (workerOptional.isPresent()){
            workerService.delete(workerOptional.get().getId());
            return ResponseEntity.accepted().build();
        }

        return ResponseEntity.notFound().build();
    }
}
