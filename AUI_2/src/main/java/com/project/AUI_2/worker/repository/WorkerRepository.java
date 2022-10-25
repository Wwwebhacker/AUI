package com.project.AUI_2.worker.repository;

import com.project.AUI_2.company.entity.Company;
import com.project.AUI_2.worker.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

    List<Worker> findAllByCompany(Company company);
}
