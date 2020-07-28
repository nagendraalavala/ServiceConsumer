package com.example.retailservice;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class RetailService
{

    private RetailRepository repo;
    private RestTemplate restTemplate;
    private ProductEntity productEntity;
    public static final Logger logger = LoggerFactory.getLogger(RetailServiceApplication.class);

    @Autowired
    public RetailService(RetailRepository repo, RestTemplate restTemplate) {
        this.repo = repo;
        this.restTemplate = restTemplate;
        this.productEntity = new ProductEntity();
    }

    //add
    public ResponseEntity<RetailEntity> addRetail(RetailEntity retailEntity)
    {
        String url = "http://localhost:8091/api/v1/";
        ResponseEntity<ProductEntity> productEntity = restTemplate.exchange(url+retailEntity.getId(),
                HttpMethod.GET,null,ProductEntity.class);
        ProductEntity getProduct = productEntity.getBody();
        logger.info("Received ProductEntity from Product Service");
        logger.info("Checking for stock Active Status");
        if(getProduct.getStock().equals("Active"))
        {
            logger.info("Product Stock status was active and creating RetailEntity ");
            retailEntity.setProduct(getProduct.getName());
            return   new ResponseEntity<>(repo.save(retailEntity),HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }



    }

    public Optional<RetailEntity> getRetail(Long id)
    {
        return (Optional<RetailEntity>) repo.findById( id);
    }


}
