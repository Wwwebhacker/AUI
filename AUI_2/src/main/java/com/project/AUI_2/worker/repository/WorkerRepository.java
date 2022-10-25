package com.project.AUI_2.worker.repository;

import com.project.AUI_2.datastore.DataStore;
import com.project.AUI_2.worker.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {


}
