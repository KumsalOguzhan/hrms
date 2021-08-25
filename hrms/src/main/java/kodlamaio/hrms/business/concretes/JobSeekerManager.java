package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmailCheckService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.adapter.MernisValidationService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {
    private JobSeekerDao jobSeekerDao;
    private MernisValidationService mernisValidationService;
    private EmailCheckService emailCheckService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao,
                            MernisValidationService mernisValidationService, EmailCheckService emailCheckService) {
        this.jobSeekerDao = jobSeekerDao;
        this.mernisValidationService = mernisValidationService;
        this.emailCheckService = emailCheckService;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<>(this.jobSeekerDao.findAll(), "İş arayanlar listelendi.");
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        if (this.mernisValidationService.validateWithMernis(jobSeeker).isSuccess()
                && emailCheckService.emailCheck(jobSeeker)){
            this.jobSeekerDao.save(jobSeeker);
            return new SuccessResult("İş arayan eklendi");
        }else {
            return new ErrorResult("İş arayan doğrulanamadı");
        }
    }
}
