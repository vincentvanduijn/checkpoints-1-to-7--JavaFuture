package com.devoteam.VehicleApplication.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Vehicle implements VehicleInterface {

    private int id;
    private Date createdOn;
    private Automaker automaker;
    private String model;
    private String color;
    private int year;
    private VehicleTypeEnum vehicleType;

    @Override
    public String toString() {
        return  "\n#------------------------------------------------#\n" +
                "Model: " + model + "\n" +
                "Id Vehicle: " + id + '\n' +
                "Vehicle type: " + vehicleType + "\n" +
                "Color: " + color + "\n" +
                "Year: " + year + "\n" +
                "Created on: " + createdOn + "\n"
                ;
    }
}
