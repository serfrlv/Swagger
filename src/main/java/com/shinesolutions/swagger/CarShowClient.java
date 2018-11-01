package com.shinesolutions.swagger;


import com.shinesolutions.swagger.model.Car;
import com.shinesolutions.swagger.model.CarShow;
import com.shinesolutions.swagger.service.CarShowServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarShowClient {

    private static final Logger log = LoggerFactory.getLogger(CarShowClient.class);
    @Autowired
    private CarShowServiceImpl carShowService;

    public String getHeaders(){
        return carShowService.getResponseHeader();
    }
//
    public String getResponseContent(){
        return carShowService.getResponseContent();
    }

    public int getStatusCode(){
            return carShowService.getResponseStatus();
    }

    public List<Car> getCars() throws Exception {
        List<Car> cars = new ArrayList<Car>();
        try {
            ResponseEntity<List<CarShow>> entity = carShowService.getResponseEntity();
            if(entity.getStatusCode()!=null && entity.getStatusCode().is2xxSuccessful()){
                List<CarShow> carShows = entity.getBody();
                for (CarShow carShow: carShows) {
                    for(Car car:carShow.getCars()){
                        cars.add(car);
                    }
                }
            }
        }catch (HttpMessageNotReadableException e) {
            log.error("HttpMessageNotReadableException");
        }catch (RestClientException e){
            log.error("RestClientException");
        }catch (Exception e){
            log.error("Exception!");
        }

        return cars;
    }
}
