package pg.edu.pg.eti.kask.AUI.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pg.edu.pg.eti.kask.AUI.company.dto.CreateCompanyRequest;
import pg.edu.pg.eti.kask.AUI.company.entity.Company;
import pg.edu.pg.eti.kask.AUI.company.service.CompanyService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
@RequestMapping("api/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }



    @PostMapping
    public ResponseEntity<Void> createCompany(@RequestBody CreateCompanyRequest request, UriComponentsBuilder builder) {
        Company company = CreateCompanyRequest.dtoToEntityMapper().apply(request);
        company = companyService.create(company);

        return ResponseEntity.created(builder.pathSegment("api", "companies", "{id}").buildAndExpand(company.getId()).toUri()).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable("id") long id) {
        Optional<Company> companyOptional = companyService.find(id);
        if (companyOptional.isPresent()) {
            companyService.delete(companyOptional.get().getId());

            return ResponseEntity.accepted().build();
        }

        return ResponseEntity.notFound().build();
    }
}
