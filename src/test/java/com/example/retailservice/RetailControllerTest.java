package com.example.retailservice;

import com.example.retailservice.Controller.RetailController;
import com.example.retailservice.Entity.RetailEntity;
import com.example.retailservice.Service.RetailService;
import com.example.retailservice.types.ProductEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
       // productEntity = new ProductEntity((long) 1,"Phone",250.6,"Active");
        RetailEntity retailEntity = new RetailEntity((long) 1,"Active");

        String baseurl = "http://localhost:8091/api/v1/1";

        Mockito.when(restTemplate.getForObject(baseurl,ProductEntity.class))
        .thenReturn(defaultProductEntity());

        String retailURL = "/add";

        mvc.perform(MockMvcRequestBuilders.post(retailURL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());




      //  assertEquals(service.addRetail(retailEntity),retailEntity);

    }
    protected static ProductEntity defaultProductEntity()
    {
        ProductEntity response = new ProductEntity();
        response.setId(21L);
        response.setCost(13);
        response.setName("Bottle");
        response.setStock("Active");

        return response;
    }
}
