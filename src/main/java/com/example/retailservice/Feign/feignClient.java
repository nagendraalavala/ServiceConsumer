package com.example.retailservice.Feign;

import com.example.retailservice.Feign.FallBack.feignFallBack;
import com.example.retailservice.types.ProductEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "retailservice", url = "http://localhost:8091/api/v1",fallback = feignFallBack.class )
public interface feignClient {

    @GetMapping("/{id}")
    ProductEntity productRespone(@PathVariable Long id);
}



