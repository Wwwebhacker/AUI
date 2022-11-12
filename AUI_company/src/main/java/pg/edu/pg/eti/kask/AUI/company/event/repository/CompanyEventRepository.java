package pg.edu.pg.eti.kask.AUI.company.event.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pg.edu.pg.eti.kask.AUI.company.entity.Company;
import pg.edu.pg.eti.kask.AUI.company.event.dto.CreateCompanyRequest;

@Repository
public class CompanyEventRepository {

    private RestTemplate restTemplate;

    @Autowired
    public CompanyEventRepository(@Value("${aui.workers.url}") String baseUrl) {
        restTemplate = new RestTemplateBuilder().rootUri(baseUrl).build();
    }

    public void delete(Company company) {
        restTemplate.delete("/companies/{id}", company.getId());
    }

    public void create(Company company) {
        restTemplate.postForLocation("/companies", CreateCompanyRequest.entityToDtoMapper().apply(company));
    }
}
