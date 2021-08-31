package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll(), "Şehirler listelendi");
    }

    @Override
    public Result add(City city) {
        if (this.cityDao.existCityByName(city.getName())){
            return new ErrorResult("Bu şehir zaten kayıtlı");
        }else {
            this.cityDao.save(city);
            return new SuccessResult("Şehir kaydedildi");
        }
    }
}
