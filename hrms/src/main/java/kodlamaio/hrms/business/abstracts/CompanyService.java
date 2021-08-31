package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Company;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface CompanyService {
    Result add(Company company);
    DataResult<List<JobAdvertisement>>findByJobAdvertisementStatusTrue();
}
