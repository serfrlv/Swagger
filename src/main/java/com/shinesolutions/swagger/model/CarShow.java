package com.shinesolutions.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@ToString
public class CarShow {

    private String name;
    private ArrayList<Car> cars;

    @JsonCreator
    public CarShow() {
    }

    @JsonCreator
    public CarShow(@JsonProperty("name")String name, @JsonProperty("cars")ArrayList<Car> cars) {
        this.name = name;
        this.cars = cars;
    }
}
