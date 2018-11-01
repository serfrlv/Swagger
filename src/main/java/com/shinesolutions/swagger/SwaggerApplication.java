package com.shinesolutions.swagger;

import com.shinesolutions.swagger.model.Car;
import com.shinesolutions.swagger.model.CarShow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SwaggerApplication {

	private static final Logger log = LoggerFactory.getLogger(SwaggerApplication.class);

	@Autowired
	private CarShowClient client;

	public static void main(String[] args) {
//		clientS
		SpringApplication.run(SwaggerApplication.class);
	}

	@Bean
	public CommandLineRunner run(CarShowClient clientService) throws Exception{
		return args -> {
			log.debug(client.getHeaders());
			List<Car> cars = client.getCars();
			log.debug(client.getResponseContent());
			log.debug(String.valueOf(client.getStatusCode()));
//			List<Car> cars = clientService.;
			for(Car car:cars){
				System.out.println(car.getMake());
			}
		};
	}
}
