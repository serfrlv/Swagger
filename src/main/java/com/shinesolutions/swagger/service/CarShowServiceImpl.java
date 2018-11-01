package com.shinesolutions.swagger.service;

import com.shinesolutions.swagger.CarShowClient;
import com.shinesolutions.swagger.config.SwaggerClientProperties;
import com.shinesolutions.swagger.error.RestTemplateResponseErrorHandler;
import com.shinesolutions.swagger.model.CarShow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.List;

@Service
public class CarShowServiceImpl implements EndpointService<CarShow> {

    private RestTemplate restTemplate;
    private final String serviceUrl;
    private static final Logger log = LoggerFactory.getLogger(CarShowClient.class);
    private String responseHeader = "";
    private int responseStatus = -1;
    private String responseContent = "";

    @Autowired
    public CarShowServiceImpl(RestTemplateBuilder builder, final SwaggerClientProperties properties) {
        this.serviceUrl = properties.getServiceUrl();
        this.restTemplate = builder.setConnectTimeout(Duration.ofMillis(properties.getConnectTimeout()))
                .setReadTimeout(Duration.ofMillis(properties.getReadTimeout()))
                .errorHandler(new RestTemplateResponseErrorHandler()).build();
        this.restTemplate.getMessageConverters()
                .add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    @Override
    public String getResponseHeader(){
        return this.responseHeader;
    }
    @Override
    public int getResponseStatus(){
        return  this.responseStatus;
    }
    @Override
    public String getResponseContent(){
        return  this.responseContent;
    }

    @Override
    public ResponseEntity<List<CarShow>> getResponseEntity() throws Exception{
        ResponseEntity<List<CarShow>> entity = restTemplate.exchange(serviceUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CarShow>>(){});
        this.responseContent = entity.getBody().toString();
        this.responseHeader = entity.getHeaders().toString();
        this.responseStatus = entity.getStatusCodeValue();
        return entity;
    }
}
