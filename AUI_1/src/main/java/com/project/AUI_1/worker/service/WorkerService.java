package com.project.AUI_1.worker.service;

import com.project.AUI_1.worker.entity.Worker;
import com.project.AUI_1.worker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    public Worker find(int id) {
        return workerRepository.find(id);
    }

    public void create(Worker worker) {
        workerRepository.create(worker);
    }

    public void delete(Worker worker) {
        workerRepository.delete(worker);
    }

    public void update(Worker worker) {
        workerRepository.update(worker);
    }
}
