package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmailCheckService {
    boolean emailCheck(User user);
    boolean emailDomainCheck(Employer employer);
}
