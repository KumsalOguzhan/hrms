package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.util.List;

public interface JobAdvertisementService {
    Result add(JobAdvertisement jobAdvertisement);
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> findByStatusTrue();
    DataResult<List<JobAdvertisement>> findByStatusTrueOrderByCreateDate();
    Result setJobAdvertisementStatusFalse(int id);
}
