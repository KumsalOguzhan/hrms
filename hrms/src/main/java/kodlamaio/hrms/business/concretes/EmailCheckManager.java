package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmailCheckService;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;


@Service
public class EmailCheckManager implements EmailCheckService {

    @Override
    public boolean emailCheck(User user) {
        return true;
    }

    public boolean emailDomainCheck(Employer employer){
        String[] partsOfUserEmail = employer.getEmail().split("@");
        String namePart = partsOfUserEmail[0];
        String domainPart = partsOfUserEmail[1];

        return domainPart.equals(employer.getWebsite());
    }
}
