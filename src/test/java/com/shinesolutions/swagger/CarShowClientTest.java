package com.shinesolutions.swagger;

import com.shinesolutions.swagger.model.Car;
import com.shinesolutions.swagger.model.CarModel;
import com.shinesolutions.swagger.model.CarShow;
import com.shinesolutions.swagger.service.CarShowServiceImpl;
import com.shinesolutions.swagger.service.IEndpointService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(MockitoJUnitRunner.class)
public class CarShowClientTest {

    private final Logger logger = LoggerFactory.getLogger(CarShowClientTest.class);
    @InjectMocks
    private CarShowClient carShowClient;
    @Mock
    private CarShowServiceImpl mockServer;

    @Before
    public void setUp() throws Exception {
        ArrayList<Car> carlist1 = new ArrayList<Car>();
        Car car1 = new Car("Julio Mechannica","Mark 4S");
        carlist1.add(car1);
        Car car2 = new Car("Hondaka","Elisa");
        carlist1.add(car2);
        Car car3 = new Car("Tourismo","Cyclissimo");
        carlist1.add(car3);
        Car car4 = new Car("George Motors","George 15");
        carlist1.add(car4);
        Car car5 = new Car("Moto Tourismo","Delta 4");
        carlist1.add(car5);
        CarShow show1 = new CarShow("Melbourne Motor Show",carlist1);
        ArrayList<Car> carlist2 = new ArrayList<Car>();
        Car car21 = new Car("Moto Tourismo","Cyclissimo");
        carlist2.add(car21);
        Car car22 = new Car("George Motors","George 15");
        carlist2.add(car22);
        Car car23 = new Car("Hondaka","Ellen");
        carlist2.add(car23);
        Car car24 = new Car("Moto Tourismo","Delta 16");
        carlist2.add(car24);
        Car car25 = new Car("Moto Tourismo","Delta 4");
        carlist2.add(car25);
        Car car26 = new Car("ulio Mechannica","Mark 2");
        carlist2.add(car26);
        CarShow show2 = new CarShow("Cartopia",carlist2);
        ArrayList<CarShow> carShowArrayList = new ArrayList<CarShow>();
        carShowArrayList.add(show1);
        carShowArrayList.add(show2);
        when(mockServer.doGet()).thenReturn(true);
        when(mockServer.getResponseStatus()).thenReturn(200);
        when(mockServer.getEntity()).thenReturn(new ResponseEntity<List<CarShow>>(carShowArrayList, HttpStatus.ACCEPTED));
    }
    @Test
    public void responseStatusCode_200() throws Exception{
        when(mockServer.getResponseStatus()).thenReturn(200);
        Assert.assertEquals(carShowClient.getStatusCode(),200);
    }

    @Test
    public void responseStatusCode_500() throws Exception{
        when(mockServer.getResponseStatus()).thenReturn(500);
        Assert.assertEquals(carShowClient.getStatusCode(),500);
    }

    @Test
    public void getCarNumberTest() throws Exception{
        ArrayList<CarModel> carModels = (ArrayList<CarModel>) carShowClient.getCarModelList();
        Assert.assertEquals(carModels.size(),11);
    }


}
