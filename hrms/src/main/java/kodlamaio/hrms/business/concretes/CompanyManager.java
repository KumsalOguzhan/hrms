package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrms.entities.concretes.Company;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CompanyManager implements CompanyService {

    private CompanyDao companyDao;

    @Autowired
    public CompanyManager(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public Result add(Company company) {
        if (this.companyDao.existCompanyByName(company.getName())){
            return new ErrorResult("Daha önceden varolan bir şirket ismi ile kayıt olamazsınız");
        }else {
            this.companyDao.save(company);
            return new SuccessResult("Şirketiniz kayıt edildi");
        }
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByJobAdvertisementStatusTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.companyDao.findByJobAdvertisementStatusTrue(),
                "Şirkete ait tüm aktif iş ilanları listelendi");
    }
}
