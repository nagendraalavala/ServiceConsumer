package com.example.retailservice;


import com.example.retailservice.Exception.FeignErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class RetailServiceApplication {

  public static void main(String[] args) {
		SpringApplication.run(RetailServiceApplication.class, args);
	}

	@Bean
	public ErrorDecoder errorDecoder()
	{
		return new FeignErrorDecoder();
	}

}
