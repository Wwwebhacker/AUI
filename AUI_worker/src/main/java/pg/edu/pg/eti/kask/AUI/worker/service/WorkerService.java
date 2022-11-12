package pg.edu.pg.eti.kask.AUI.worker.service;

import pg.edu.pg.eti.kask.AUI.company.entity.Company;
import pg.edu.pg.eti.kask.AUI.company.repository.CompanyRepository;
import pg.edu.pg.eti.kask.AUI.worker.entity.Worker;
import pg.edu.pg.eti.kask.AUI.worker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {
    private final WorkerRepository repository;
    private final CompanyRepository companyRepository;

    @Autowired
    public WorkerService(WorkerRepository repository, CompanyRepository companyRepository) {
        this.repository = repository;
        this.companyRepository = companyRepository;
    }

    public List<Worker> findAll() {
        return repository.findAll();
    }

    public List<Worker> findAll(Company company) {
        return repository.findAllByCompany(company);
    }

    public Optional<Worker> find(Long id) {
        return repository.findById(id);
    }

    public Optional<Worker> find(Long workerId, Long companyId) {
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        if (companyOptional.isPresent()) {
            return repository.findByIdAndCompany(workerId, companyOptional.get());
        }

        return Optional.empty();
    }

    @Transactional
    public Worker create(Worker worker) {
        return repository.save(worker);
    }

    @Transactional
    public void delete(Long worker) {
        repository.deleteById(worker);
    }

    @Transactional
    public void update(Worker worker) {
        repository.save(worker);
    }
}
