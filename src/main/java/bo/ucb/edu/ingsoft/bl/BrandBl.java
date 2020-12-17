package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.BrandDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.BrandDto;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandBl {
    private BrandDao brandDao;
    private TransactionDao transactionDao;

    @Autowired
    public BrandBl(BrandDao brandDao, TransactionDao transactionDao){
        this.brandDao = brandDao;
        this.transactionDao = transactionDao;
    }

    public BrandDto createBrand(BrandDto brandDto, Transaction transaction){
        Brand brand=new Brand();
        brand.setName(brandDto.getName());
        brand.setTxId(transaction.getTxId());
        brand.setTxUserId(transaction.getTxUserId());
        brand.setTxHost(transaction.getTxHost());
        brand.setTxDate(transaction.getTxDate());
        brand.setStatus(1);
        brandDao.create(brand);
        Integer getLastId = transactionDao.getLastInsertId();
        brandDto.setBrandId(getLastId);
        return brandDto;
    }

    public BrandDto findBrandById(Integer brandId) {
        BrandDto brandDto= new BrandDto();
        Brand brandResponse= brandDao.findByBrandId(brandId);
        brandDto.setBrandId(brandResponse.getBrandId());
        brandDto.setName(brandResponse.getName());
        return brandDto;
    }

    public List<BrandDto> listBrand(){
        List<Brand> brands = brandDao.getBrand();
        List<BrandDto> brandsDto = new ArrayList<BrandDto>();
        for(int i=0; i<brands.size(); i++){
            Brand brand = brands.get(i);
            BrandDto brandDto = new BrandDto();

            brandDto.setBrandId(brand.getBrandId());
            brandDto.setName(brand.getName());

            brandsDto.add(i, brandDto);
        }
        return brandsDto;
    }

    public BrandDto updateBrand(BrandDto brandDto, Transaction transaction){
        Brand brand = new Brand();
        brand.setBrandId(brandDto.getBrandId());
        brand.setName(brandDto.getName());
        brand.setTxId(transaction.getTxId());
        brand.setTxUserId(transaction.getTxUserId());
        brand.setTxHost(transaction.getTxHost());
        brand.setTxDate(transaction.getTxDate());
        brand.setStatus(1);
        brandDao.update(brand);
        return brandDto;
    }

    public Brand delete(Integer brandId, Transaction transaction)
    {
        Brand brand= new Brand();
        brand.setBrandId(brandId);
        brand.setTxId(transaction.getTxId());
        brand.setTxUserId(transaction.getTxUserId());
        brand.setTxHost(transaction.getTxHost());
        brand.setTxDate(transaction.getTxDate());
        brand.setStatus(0);
        brandDao.delete(brand);
        return brand;
    }

}
