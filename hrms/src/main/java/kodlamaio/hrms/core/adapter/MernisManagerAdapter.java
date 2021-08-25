package kodlamaio.hrms.core.adapter;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.fakeMernis.MernisManager;
import org.springframework.context.annotation.Bean;

public class MernisManagerAdapter implements MernisValidationService{
    @Override
    @Bean
    public DataResult<User> validateWithMernis(User user) {
        MernisManager mernisManager = new MernisManager();
        return new DataResult<>(user, mernisManager.validation(user));
    }
}
