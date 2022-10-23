package com.example.demo.service;

import com.example.demo.entity.Worker;
import com.example.demo.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {
    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public Worker find(Integer id){
        return workerRepository.find(id);
    }

    public void create(Worker worker){
        workerRepository.create(worker);
    }

    public void delete(Worker worker){
        workerRepository.delete(worker);
    }

    public void update(Worker worker){
        workerRepository.update(worker);
    }
}
