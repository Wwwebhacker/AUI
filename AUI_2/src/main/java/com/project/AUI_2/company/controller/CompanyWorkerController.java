package com.project.AUI_2.company.controller;

import com.project.AUI_2.company.dto.GetCompanyWorkersResponse;
import com.project.AUI_2.company.entity.Company;
import com.project.AUI_2.company.service.CompanyService;
import com.project.AUI_2.worker.entity.Worker;
import com.project.AUI_2.worker.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
    public ResponseEntity<GetCompanyWorkersResponse> getCompanyWorkers(@PathVariable("id") Long id){
        Optional<Company> companyOptional = companyService.find(id);
        return companyOptional.map(value -> ResponseEntity.ok(GetCompanyWorkersResponse.entityToDtoMapper().apply(workerService.findAll(value))))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }
}
