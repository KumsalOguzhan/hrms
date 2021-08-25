package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmailCheckService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.adapter.MernisValidationService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private MernisValidationService mernisValidationService;
    private EmailCheckService emailCheckService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, MernisValidationService mernisValidationService,
                           EmailCheckService emailCheckService) {
        this.employerDao = employerDao;
        this.mernisValidationService = mernisValidationService;
        this.emailCheckService = emailCheckService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data listelendi");
    }

    @Override
    public Result add(Employer employer) {
        if (emailCheckService.emailCheck(employer) && emailCheckService.emailDomainCheck(employer)){
            this.employerDao.save(employer);
            return new SuccessResult("İşveren eklendi");
        }else {
            return new ErrorResult("İşveren maili doğrulanamadı");
        }
    }
}
