package com.example.retailservice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RetailControllerTest
{
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private RetailController controller;

    @Mock
    private RetailService service;


    private ProductEntity productEntity;

    private MockMvc mvc;

    @Before
    public void setup(){

        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void creat_retail_with_restTemplate_Success() throws Exception
    {
        productEntity = new ProductEntity((long) 1,"Phone",250.6,"Active");
        RetailEntity retailEntity = new RetailEntity((long) 1,"Active",productEntity.getName());

        String baseurl = "http://localhost:8091/api/v1/1";

        Mockito.when(restTemplate.exchange(baseurl, HttpMethod.GET,null,RetailEntity.class))
        .thenReturn(new ResponseEntity<>(retailEntity, HttpStatus.CREATED));

        String retailURL = "/add";

        mvc.perform(MockMvcRequestBuilders.post(retailURL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON_VALUE));



            ResponseEntity<RetailEntity> retailEntity1 = service.addRetail(retailEntity);

        assertEquals(retailEntity1,retailEntity);












    }
}
