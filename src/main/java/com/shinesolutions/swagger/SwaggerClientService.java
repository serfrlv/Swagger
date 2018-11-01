package com.shinesolutions.swagger;

import com.shinesolutions.swagger.config.SwaggerClientProperties;
import com.shinesolutions.swagger.error.RestTemplateResponseErrorHandler;
import com.shinesolutions.swagger.model.Car;
import com.shinesolutions.swagger.model.CarShow;
import com.shinesolutions.swagger.service.CarShowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import java.util.ArrayList;
import java.util.List;

@Component
public class SwaggerClientService {

    @Autowired
    private CarShowServiceImpl carShowService;

    public List<CarShow> getCars()throws Exception{
        ResponseEntity<List<CarShow>> entity = carShowService.getResponseEntity();
        List<CarShow> carShows = entity.getBody();
        return carShows;
    }

    public String sortCars(){
        return null;
    }

//    public List<Car> getCars1(){
//        HttpHeaders headers = new HttpHeaders();
//        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
//        headers.setContentType(type);
//        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
//
//        HttpEntity<String> formEntity = new HttpEntity<String>(json, headers);
//        List<Car> cars = new ArrayList<Car>();
//        try {
//            ResponseEntity<List<CarShow>> response = rest.exchange(serviceUrl,
//                    HttpMethod.GET,
//                    null,
//                    new ParameterizedTypeReference<List<CarShow>>(){});
//            List<CarShow> carShows = response.getBody();
//            for (CarShow carShow: carShows) {
//                cars.addAll(carShow.getCars());
//            }
//        } catch (HttpMessageNotReadableException e) {
//
//        }
//
//
//        return cars;
//    }

}
