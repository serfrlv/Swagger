package com.shinesolutions.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@ToString
public class Car implements Comparable{

    private String make;
    private String model;

    @JsonCreator
    public Car() {

    }

    @JsonCreator
    public Car(@JsonProperty("make")String make, @JsonProperty("model")String model) {
        this.make = make;
        this.model = model;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
