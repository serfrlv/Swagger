package com.shinesolutions.swagger;

import com.shinesolutions.swagger.model.Car;
import com.shinesolutions.swagger.model.CarModel;
import com.shinesolutions.swagger.model.CarShow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class SwaggerApplication {

	private static final Logger log = LoggerFactory.getLogger(SwaggerApplication.class);

	@Autowired
	private CarShowClient client;

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class);
	}

	@Bean
	public CommandLineRunner run(CarShowClient clientService) throws Exception{
		return args -> {
			List<CarModel> carModelList =new ArrayList<CarModel>();
			while(client.getStatusCode()!= HttpStatus.OK.value()){
				carModelList = client.getCarModelList();
			}
			Map<String,List<CarModel>> groupBy = carModelList.stream().collect(Collectors.groupingBy(CarModel::getMakeName));
			Iterator<Map.Entry<String,List<CarModel>>> entries = groupBy.entrySet().iterator();
			while(entries.hasNext()){
				Map.Entry<String,List<CarModel>> entry = entries.next();
				System.out.println(entry.getKey());
				List<CarModel> list = entry.getValue();
				for(CarModel carModel:list){
					System.out.println("           "+carModel.getModelName());
					System.out.println("                    "+carModel.getAttendName());
				}
			}
			log.debug(client.getHeaders());
		};
	}
}
