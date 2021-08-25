package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmailCheckService;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.entities.concretes.Employer;

import java.util.regex.Pattern;

public class EmailCheckManager implements EmailCheckService {

    @Override
    public boolean emailCheck(User user) {
        return true;
    }

    public boolean emailDomainCheck(Employer employer){
        String[] partsOfUserEmail = employer.getEmail().split("@");
        String namePart = partsOfUserEmail[0];
        String domainPart = partsOfUserEmail[1];

        if (domainPart.equals(employer.getWebsite())){
            return true;
        }else {
            return false;
        }
    }
}
