package com.example.retailservice.Controller;

import com.example.retailservice.Entity.RetailEntity;
import com.example.retailservice.Exception.BadRequestException;
import com.example.retailservice.Service.RetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@EnableFeignClients(basePackageClasses = RetailService.class)
public class RetailController
{
    @Autowired
    private RetailService retailService;

    @PostMapping("/add")
    public ResponseEntity<RetailEntity> RetailAdd(@RequestBody RetailEntity retailEntity) throws BadRequestException {   RetailEntity response =retailService.checkThroughFeign(retailEntity);
        return response != null ? new ResponseEntity<>(response, HttpStatus.CREATED) :  new ResponseEntity<>(HttpStatus.BAD_REQUEST);


    }

    @GetMapping("/{id}")
    public Optional<RetailEntity> getRetail(@PathVariable Long id)
    {
        return retailService.getRetail(id);
    }

    @GetMapping("/get")
    public List<RetailEntity> getAllRetails()
    {
        return retailService.AllRetails();
    }
}
