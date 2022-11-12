package pg.edu.pg.eti.kask.AUI.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pg.edu.pg.eti.kask.AUI.company.entity.Company;
import pg.edu.pg.eti.kask.AUI.company.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository repository;

    @Autowired
    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public List<Company> findAll() {
        return repository.findAll();
    }

    public Optional<Company> find(Long id) {
        return repository.findById(id);
    }

    public Company create(Company company) {
        return repository.save(company);
    }

    public void delete(Long company) {
        repository.deleteById(company);
    }

    public void update(Company company) {
        repository.save(company);
    }
}
