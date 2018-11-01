package com.shinesolutions.swagger.model;


import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

/*
    represent for the car model, for Sorting and grouping
 */
@Setter
@Getter
public class CarModel {
    private String modelName = "";
    private String makeName = "";
    private String attendName = "";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModel carModel = (CarModel) o;
        return Objects.equals(modelName, carModel.modelName) &&
                Objects.equals(makeName, carModel.makeName) &&
                Objects.equals(attendName, carModel.attendName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelName, makeName, attendName);
    }

}
