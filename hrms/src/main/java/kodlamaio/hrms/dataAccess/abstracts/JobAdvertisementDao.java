package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> findByStatusTrue();
    List<JobAdvertisement> findByStatusTrueOrderByCreateDate();

    @Modifying
    @Query("update JobAdvertisement j set j.status = false where j.id = :id")
    void setJobAdvertisementStatusFalse(@Param(value = "id") int id);
}
