package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.CityDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.CityDto;
import bo.ucb.edu.ingsoft.dto.CompanyDto;
import bo.ucb.edu.ingsoft.model.City;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityBl {
    private CityDao cityDao;
    private TransactionDao transactionDao;

    @Autowired
    public CityBl(CityDao cityDao, TransactionDao transactionDao) {
        this.cityDao = cityDao;
        this.transactionDao = transactionDao;
    }

    public CityDto createCity(CityDto cityDto, Transaction transaction){
        City city=new City();
        city.setCityName(cityDto.getCityName());
        city.setTxId(transaction.getTxId());
        city.setTxUserId(transaction.getTxUserId());
        city.setTxHost(transaction.getTxHost());
        city.setTxDate(transaction.getTxDate());
        city.setStatus(1);
        cityDao.create(city);
        Integer getLastId = transactionDao.getLastInsertId();
        cityDto.setCityId(getLastId);
        return cityDto;
    }
    public CityDto findCityById(Integer cityId) {
        CityDto cityDto=new CityDto();
        City cityResponse= cityDao.findByCityId(cityId);
        cityDto.setCityId(cityResponse.getCityId());
        cityDto.setCityName(cityResponse.getCityName());
        return cityDto;
    }
    public List<CityDto> listCity(){
        List<City> cities = cityDao.getCity();
        List<CityDto> citiesDto = new ArrayList<CityDto>();
        for(int i=0; i<cities.size(); i++){
            City city = cities.get(i);
            CityDto cityDto = new CityDto();

            cityDto.setCityId(city.getCityId());
            cityDto.setCityName(city.getCityName());

            citiesDto.add(i, cityDto);
        }
        return citiesDto;
    }
}
