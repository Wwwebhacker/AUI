package com.project.AUI_2.company.repository;

import com.project.AUI_2.company.entity.Company;
import com.project.AUI_2.datastore.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

}
