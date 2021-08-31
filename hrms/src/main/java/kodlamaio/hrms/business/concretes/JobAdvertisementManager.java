package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("İş ilanı kaydedildi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),
                "Tüm iş ilanları getirildi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByStatusTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByStatusTrue(),
        "Aktif olan tüm iş ilanları getirildi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByStatusTrueOrderByCreateDate() {
        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementDao.findByStatusTrueOrderByCreateDate(), "Tarihe göre aktif iş ilanları" +
                        "sıralandı");
    }

    @Override
    public Result setJobAdvertisementStatusFalse(int id) {
        this.jobAdvertisementDao.setJobAdvertisementStatusFalse(id);
        return new SuccessResult("İş ilanı başarıyla pasif hale getirildi");
    }
}
