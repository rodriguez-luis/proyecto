package bo.ucb.edu.ingsoft.api;


import bo.ucb.edu.ingsoft.bl.ProductTypeBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.ProductTypeDto;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.apache.ibatis.ognl.ObjectElementsAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/v1/producttype")
public class ProductType {
    private ProductTypeBl productTypeBl;
    private TransactionBl transactionBl;


    @Autowired
    public ProductType(ProductTypeBl productTypeBl, TransactionBl transactionBl) {
        this.productTypeBl = productTypeBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductTypeDto> listProducttype(HttpServletRequest request) {
        return productTypeBl.listProducttype();
    }

//    @RequestMapping( value="/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ProductTypeDto findById(@PathVariable("id") Integer id, HttpServletRequest request) {
//        return productTypeBl.findByProductTypeById(id);
//    }

    @RequestMapping( value="/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable("id") Integer id, HttpServletRequest request) {
        ProductTypeDto productTypeDto = null;
        Map<String, Object> response = new HashMap<>();

        try{
            productTypeDto = productTypeBl.findByProductTypeById(id);
            if (productTypeDto == null){
                response.put("mnje", "El  pt id ".concat(id.toString().concat("no existe en db")));
                return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<ProductTypeDto>(productTypeDto,HttpStatus.OK);
        }
        catch (DataAccessException e){
            response.put("mnje", "El  pt id ".concat(id.toString().concat("Error db")));
            return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);

        }



    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ProductTypeDto productTypeCreate (@RequestBody ProductTypeDto productTypeDto,
HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        ProductTypeDto productTypeResponse = productTypeBl.productTypeCreate(productTypeDto, transaction);
        return productTypeResponse;

//    public ResponseEntity<?> productTypeCreate (@Valid @RequestBody ProductTypeDto productTypeDto,
//                                             HttpServletRequest request, BindingResult result){
//        Map<String, Object> response = new HashMap<>();
//
//        if (result.hasErrors()) {
//            List<String> errors = new ArrayList<>();
//           for( FieldError err: result.getFieldErrors()){
//               errors.add(err.getDefaultMessage());
//           }
//            response.put("errores",errors);
//           return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
//
//       }
//        Transaction transaction = TransactionUtil.createTransaction(request);
//        transactionBl.createTransaction(transaction);
//        ProductTypeDto productTypeDtoResponse = productTypeBl.productTypeCreate(productTypeDto,transaction);
//        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }




    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer productTypeId, HttpServletRequest request ){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transaction=transactionBl.createTransaction(transaction);
        productTypeBl.delete(productTypeId, transaction);
    }


     @RequestMapping( method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductTypeDto update( @RequestBody ProductTypeDto ProductTypeDto, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction((transaction));
        ProductTypeDto ProductTypeDtoResponse = productTypeBl.updateProductType(ProductTypeDto , transaction);
        return ProductTypeDtoResponse;


}}
