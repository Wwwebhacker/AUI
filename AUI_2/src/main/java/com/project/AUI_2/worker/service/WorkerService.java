package com.project.AUI_2.worker.service;

import com.project.AUI_2.worker.entity.Worker;
import com.project.AUI_2.worker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {
    private final WorkerRepository repository;

    @Autowired
    public WorkerService(WorkerRepository repository) {
        this.repository = repository;
    }

    public List<Worker> findAll() {
        return repository.findAll();
    }

    public Optional<Worker> find(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void create(Worker worker) {
        repository.save(worker);
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
