package com.devoteam.VehicleApplication.domain;

import java.util.Date;

public class Motorcycle extends Vehicle {

    public Motorcycle(int id, Date createdOn, Automaker automaker, String model, String color, int year, VehicleTypeEnum vehicleType) {
        super(id, createdOn, automaker, model, color, year, vehicleType);
    }
}
