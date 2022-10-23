package com.example.demo.repository;

import com.example.demo.datastore.DataStore;
import com.example.demo.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WorkerRepository {

    private final DataStore dataStore;

    @Autowired
    public WorkerRepository(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public List<Worker> findAll() {
        return new ArrayList<>(dataStore.workerList);
    }
    public void create(Worker entity) {
        dataStore.workerList.add(entity);
    }
    public Worker find(Integer id) {
        for (Worker worker : dataStore.workerList){
            if (worker.getId().equals(id)){
                return worker;
            }
        }
        return null;
    }
    public void update(Worker entity) {
        Worker worker = this.find(entity.getId());
        delete(worker);
        create(entity);
    }
    public void delete(Worker entity) {
        dataStore.workerList.remove(entity);
    }
}
