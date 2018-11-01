package com.shinesolutions.swagger;


import com.shinesolutions.swagger.model.Car;
import com.shinesolutions.swagger.model.CarModel;
import com.shinesolutions.swagger.model.CarShow;
import com.shinesolutions.swagger.service.IEndpointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarShowClient {

    private static final Logger log = LoggerFactory.getLogger(CarShowClient.class);
    @Autowired
    private IEndpointService carShowService;

    public String getHeaders(){
        return carShowService.getResponseHeader();
    }

    public String getResponseContent(){
        return carShowService.getResponseContent();
    }

    public int getStatusCode(){
            return carShowService.getResponseStatus();
    }

    public List<CarModel> getCarModelList(){
        List<CarModel> CarModelList = new ArrayList<CarModel>();
        try {
            if(carShowService.doGet()){
               List<CarShow> carShows = (List<CarShow>) carShowService.getEntity().getBody();
                for (CarShow carShow: carShows) {
                    for(Car car:carShow.getCars()){
                       CarModel carModel = new CarModel();
                       carModel.setAttendName(carShow.getName()==null?"1":carShow.getName());
                       carModel.setMakeName(car.getMake()==null?"1":car.getMake());
                       carModel.setModelName(car.getMake()==null?"1":car.getModel());
                       CarModelList.add(carModel);
                    }
                }
            }
        }catch (HttpMessageNotReadableException e) {
            log.error("HttpMessageNotReadableException");
        }catch (RestClientException e){
            log.error("RestClientException");
        }catch (Exception e){
            e.printStackTrace();
            log.error("Exception!");
        }
        return CarModelList;

    }
}
