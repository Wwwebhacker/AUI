package pg.edu.pg.eti.kask.AUI.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pg.edu.pg.eti.kask.AUI.company.entity.Company;
import pg.edu.pg.eti.kask.AUI.company.event.repository.CompanyEventRepository;
import pg.edu.pg.eti.kask.AUI.company.repository.CompanyRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository repository;

    private final CompanyEventRepository companyEventRepository;

    @Autowired
    public CompanyService(CompanyRepository repository, CompanyEventRepository companyEventRepository) {
        this.repository = repository;
        this.companyEventRepository = companyEventRepository;
    }

    public List<Company> findAll() {
        return repository.findAll();
    }

    public Optional<Company> find(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Company create(Company company) {
        companyEventRepository.create(company);
        return repository.save(company);
    }

    @Transactional
    public void delete(Company company) {
        companyEventRepository.delete(company);
        repository.delete(company);
    }

    public void update(Company company) {
        repository.save(company);
    }
}
