package com.project.AUI_1.worker.repository;

import com.project.AUI_1.datastore.DataStore;
import com.project.AUI_1.worker.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WorkerRepository {

    private final DataStore dataStore;
    private int id = 0;

    @Autowired
    public WorkerRepository(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public List<Worker> findAll() {
        return new ArrayList<>(dataStore.workerList);
    }

    public void create(Worker entity) {
        entity.setId(id++);
        dataStore.workerList.add(entity);
    }

    public Worker find(int id) {
        for (Worker worker : dataStore.workerList) {
            if (worker.getId() == id) {
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
