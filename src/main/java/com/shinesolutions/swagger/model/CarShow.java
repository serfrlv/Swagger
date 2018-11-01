package com.shinesolutions.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarShow carShow = (CarShow) o;
        return Objects.equals(name, carShow.name) &&
                Objects.equals(cars, carShow.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cars);
    }
}
