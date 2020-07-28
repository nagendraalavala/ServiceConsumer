package com.example.retailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetailController
{
    @Autowired
    private RetailService retailService;

    @PostMapping("/add")
    public ResponseEntity<RetailEntity> RetailAdd(@RequestBody RetailEntity retailEntity)
    {
        return retailService.addRetail(retailEntity);
    }
}
