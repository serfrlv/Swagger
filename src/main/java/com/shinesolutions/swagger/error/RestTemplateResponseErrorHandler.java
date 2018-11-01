package com.shinesolutions.swagger.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.net.URI;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    private Logger log = LoggerFactory.getLogger(ResponseErrorHandler.class);
    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
//        return (
//                clientHttpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
//                || clientHttpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR
//                || clientHttpResponse.getStatusCode() == HttpStatus.NOT_FOUND
//                || clientHttpResponse ==null);
        return (
                clientHttpResponse.getStatusCode().isError()
                ||clientHttpResponse.getStatusCode().is4xxClientError()
                ||clientHttpResponse.getStatusCode().is5xxServerError()
                );
    }


    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        if(clientHttpResponse.getStatusCode().isError()){
            log.error(clientHttpResponse.getStatusCode().toString());
            return;
        }else if(clientHttpResponse.getStatusCode().is4xxClientError()){
            log.error(clientHttpResponse.getStatusCode().toString());
            return;
        }else if(clientHttpResponse.getStatusCode() == HttpStatus.NOT_FOUND){
            log.error(clientHttpResponse.getStatusCode().toString());
            return;
        }
    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse clientHttpResponse) throws IOException {
        if(clientHttpResponse.getStatusCode().isError()){
            log.error(clientHttpResponse.getStatusCode().toString());
            return;
        }else if(clientHttpResponse.getStatusCode().is4xxClientError()){
            log.error(clientHttpResponse.getStatusCode().toString());
            return;
        }else if(clientHttpResponse.getStatusCode() == HttpStatus.NOT_FOUND){
            log.error(clientHttpResponse.getStatusCode().toString());
            return;
        }
    }
}
