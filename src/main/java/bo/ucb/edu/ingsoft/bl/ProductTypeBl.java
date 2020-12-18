package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.ProductTypeDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.ProductTypeDto;
import bo.ucb.edu.ingsoft.model.Company;
import bo.ucb.edu.ingsoft.model.ProductType;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class ProductTypeBl {
    private ProductTypeDao productTypeDao;
    private TransactionDao transactionDao;


    @Autowired
    public ProductTypeBl(ProductTypeDao productTypeDao, TransactionDao transactionDao) {
        this.productTypeDao = productTypeDao;
        this.transactionDao = transactionDao;
    }

    public List<ProductTypeDto> listProducttype(){
        List<ProductType> productTypes = productTypeDao.getProducttype();
        List<ProductTypeDto> productTypeDtos = new ArrayList<ProductTypeDto>();

        for(int i=0; i < productTypes.size(); i++){
            ProductType productType = productTypes.get(i);
            ProductTypeDto productTypeDto = new ProductTypeDto();

            productTypeDto.setProductTypeId(productType.getProductTypeId());
            productTypeDto.setTypeName(productType.getType_name());


            productTypeDtos.add(i, productTypeDto);
        }
        return productTypeDtos;
    }


    public ProductTypeDto findByProductTypeById (Integer productTypeId){
        Map<String, Object> response = new HashMap<>();
        Integer lalo = null;

        Optional<ProductType> optional = Optional.ofNullable(this.productTypeDao.findProductTypeById(productTypeId));
        if (optional.isPresent()) {

        } else {
            throw new RuntimeException("No se pudo encontrar ese productType  " + productTypeId);
        }



        ProductType productType = productTypeDao.findProductTypeById(productTypeId);

        ProductTypeDto productTypeDto = new ProductTypeDto();
        try{
        productTypeDto.setProductTypeId(productType.getProductTypeId());
        lalo = productType.getProductTypeId();
            if (lalo == null){
                response.put("mnje", "El  pt id ".concat(productTypeId.toString().concat("no existe en db")));
                System.out.println(productTypeId);
              //  return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
            }
        }catch (DataAccessException e){
            productTypeDto.setProductTypeId(productType.getProductTypeId());
            if (lalo == null){
                response.put("mnje", "El  pt id ".concat(productTypeId.toString().concat("no existe en db")));
                System.out.println(productTypeId);
                //  return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
            }
            response.put("mnje", "El  pt id ".concat(productTypeId.toString().concat("Error db")));
           // return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
            System.out.println(productTypeId);


        }
        productTypeDto.setTypeName(productType.getType_name());
        return productTypeDto;
    }


    public ProductTypeDto productTypeCreate(ProductTypeDto productTypeDto, Transaction transaction){
        ProductType productType = new ProductType();
        productType.setType_name(productTypeDto.getTypeName());
        productType.setTxId(transaction.getTxId());
        productType.setTxUserId(transaction.getTxUserId());
        productType.setTxHost(transaction.getTxHost());
        productType.setTxDate(transaction.getTxDate());
        productType.setStatus(1);

        productTypeDao.create(productType);
        Integer getLastId = transactionDao.getLastInsertId();
        productTypeDto.setProductTypeId(getLastId);
        return productTypeDto;
    }


    public ProductTypeDto updatePtype(ProductTypeDto productTypeDto, Transaction transaction){
        ProductType productType = new ProductType();

        productType.setType_name(productTypeDto.getTypeName());
        productType.setTxId(transaction.getTxId());
        productType.setTxUserId(transaction.getTxUserId());
        productType.setTxHost(transaction.getTxHost());
        productType.setTxDate(transaction.getTxDate());
        productType.setStatus(1);
        productTypeDao.update(productType);
        return productTypeDto;

    }

    public void delete(Integer productTypeId, Transaction transaction)
    {
        ProductType productType= new ProductType();
        productType.setProductTypeId(productTypeId);
        productType.setTxId(transaction.getTxId());
        productType.setTxUserId(transaction.getTxUserId());
        productType.setTxHost(transaction.getTxHost());
        productType.setTxDate(transaction.getTxDate());
        productType.setStatus(0);
        productTypeDao.delete(productType);

    }

    public ProductTypeDto updateProductType(ProductTypeDto productTypeDto, Transaction transaction) {

      //  ProductType productTypeInfo = productTypeDao.productTypeInfo(productTypeId);
       // System.out.println(productTypeId);

        ProductType productType= new ProductType();

        System.out.println(productType);
        productType.setProductTypeId(productTypeDto.getProductTypeId());

      //  productType.setProductTypeId(productTypeId);
        productType.setType_name(productTypeDto.getTypeName());
     //   productType.setType_name("MB");
        productType.setStatus(1);
        productType.setTxId(transaction.getTxUserId());
        productType.setTxUserId(transaction.getTxUserId());
        productType.setTxHost(transaction.getTxHost());
        productType.setTxDate(transaction.getTxDate());
        System.out.println(productType);

        productTypeDao.update(productType);

        System.out.println(productType);
        System.out.println(productType);
        System.out.println(productType);

        return productTypeDto;





//        ProductType prod = productTypeDao.productTypeInfo(productTypeId);
//        if (prod == null || prod.getStatus() == 0) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
//        }
//
//
//        ProductType productType= new ProductType();
//        productType.setProductTypeId(productTypeId);
//        //productType.setType_name(productTypeDto.getTypeName());
//        productType.setType_name("MB");
//        productType.setStatus(1);
//        productType.setTxId(transaction.getTxUserId());
//        productType.setTxUserId(transaction.getTxUserId());
//        productType.setTxHost(transaction.getTxHost());
//        productType.setTxDate(transaction.getTxDate());
//        System.out.println(productType);
//
//        productTypeDao.update(productType);
//        return productTypeDto;



    }

}