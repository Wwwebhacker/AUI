package com.project.AUI_2.company.controller;

import com.project.AUI_2.company.dto.CreateWorkerRequest;
import com.project.AUI_2.company.dto.GetCompanyWorkerResponse;
import com.project.AUI_2.company.dto.GetCompanyWorkersResponse;
import com.project.AUI_2.company.dto.UpdateWorkerRequest;
import com.project.AUI_2.company.entity.Company;
import com.project.AUI_2.company.service.CompanyService;
import com.project.AUI_2.worker.entity.Worker;
import com.project.AUI_2.worker.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("api/companies/{id}/workers")
public class CompanyWorkerController {

    private final CompanyService companyService;
    private final WorkerService workerService;

    @Autowired
    public CompanyWorkerController(CompanyService companyService, WorkerService workerService) {
        this.workerService = workerService;
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<GetCompanyWorkersResponse> getWorkers(@PathVariable("id") Long id) {
        Optional<Company> companyOptional = companyService.find(id);

        return companyOptional.map(value -> ResponseEntity.ok(GetCompanyWorkersResponse.entityToDtoMapper().apply(workerService.findAll(value))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping({"{worker-id}"})
    public ResponseEntity<GetCompanyWorkerResponse> getWorker(@PathVariable("worker-id") Long workerId, @PathVariable("id") Long id) {
        return workerService.find(workerId, id)
                .map(value -> ResponseEntity.ok(GetCompanyWorkerResponse.entityToDtoMapper().apply(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createWorker(@RequestBody CreateWorkerRequest request,
                                             @PathVariable("id") Long companyId,
                                             UriComponentsBuilder builder) {
        Optional<Company> companyOptional = companyService.find(companyId);
        if (companyOptional.isPresent()) {
            Worker worker = CreateWorkerRequest.dtoToEntityMapper(companyOptional::get).apply(request);
            worker = workerService.create(worker);
            return ResponseEntity.created(builder.pathSegment("api", "companies", "{companyId}", "workers", "{workerId}")
                    .buildAndExpand(companyOptional.get().getId(), worker.getId()).toUri()).build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{worker-id}")
    public ResponseEntity<Void> updateWorker(@PathVariable("worker-id") Long workerId,
                                             @PathVariable("id") Long companyId,
                                             @RequestBody UpdateWorkerRequest updateWorkerRequest) {
        Optional<Worker> workerOptional = workerService.find(workerId,companyId);
        if (workerOptional.isPresent()) {
            UpdateWorkerRequest.dtoToEntityUpdater().apply(workerOptional.get(), updateWorkerRequest);
            workerService.update(workerOptional.get());
            return ResponseEntity.accepted().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{worker-id}")
    public ResponseEntity<Void> deleteWorker(@PathVariable("worker-id") Long workerId,
                                             @PathVariable("id") Long companyId){
        Optional<Worker> workerOptional = workerService.find(workerId,companyId);
        if (workerOptional.isPresent()) {
            workerService.delete(workerOptional.get().getId());
            return ResponseEntity.accepted().build();
        }

        return ResponseEntity.notFound().build();
    }
}
