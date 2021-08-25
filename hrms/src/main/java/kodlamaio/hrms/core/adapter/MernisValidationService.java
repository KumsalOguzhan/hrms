package kodlamaio.hrms.core.adapter;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;

public interface MernisValidationService {
    DataResult<User> validateWithMernis(User user);
}
