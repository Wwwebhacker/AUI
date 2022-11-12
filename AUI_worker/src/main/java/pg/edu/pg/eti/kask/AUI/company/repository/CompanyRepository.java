package pg.edu.pg.eti.kask.AUI.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pg.edu.pg.eti.kask.AUI.company.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
