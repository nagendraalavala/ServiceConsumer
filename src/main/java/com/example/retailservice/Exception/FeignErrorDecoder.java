package com.example.retailservice.Exception;

import feign.Response;
import feign.codec.ErrorDecoder;


public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public BadRequestException decode(String s, Response response) {
        switch (response.status())
        {
            case 500:
                return new BadRequestException("Bad Request");

            default:
                return (BadRequestException) new Exception("Generic error");
        }

    }
}
