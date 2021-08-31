package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Company;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyDao extends JpaRepository<Company, Integer> {
    List<JobAdvertisement> findByJobAdvertisementStatusTrue();
    boolean existCompanyByName(String name);
}
