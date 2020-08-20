package com.example.retailservice.Exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        switch (response.status())
        {
            case 400:
                return new BadRequestException("Bad Request");
            case 404:
                return new ResourceNotFoundException("ID not Found");

            default:
                return (BadRequestException) new Exception("Generic error");
        }

    }
}
