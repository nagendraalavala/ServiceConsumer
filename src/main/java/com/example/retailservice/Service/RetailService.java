package com.example.retailservice.Service;


import com.example.retailservice.Entity.RetailEntity;
import com.example.retailservice.Feign.feignClient;
import com.example.retailservice.Repo.RetailRepository;
import com.example.retailservice.types.ProductEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RetailService
{

    private RetailEntity retailEntity;

    @Autowired
    feignClient feign;
    private RetailRepository repo;


    @Autowired
    public RetailService(
             RetailRepository repo) {
        this.retailEntity = new RetailEntity();

        this.repo = repo;
    }


    public RetailEntity checkThroughFeign(RetailEntity retailEntity)
    {
        ProductEntity productEntity = feign.productRespone(retailEntity.getId());
        if(productEntity.getStock().equals("Active"))
        {
            return repo.save(retailEntity);
        }
        else
        {
            return null ;
        }


    }

    public Optional<RetailEntity> getRetail(Long id)
    {

        return repo.findById(id);
    }

    public List<RetailEntity> AllRetails()
    {
        return repo.findAll();
    }


}
