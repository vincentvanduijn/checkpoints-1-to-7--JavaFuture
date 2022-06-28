package main.java.com.devoteam.VehicleApplication.domain;

public class Truck extends Vehicle {

    public Truck(Automaker automaker, String model, String color, int year, VehicleTypeEnum vehicleType) {
        super(automaker, model, color, year, vehicleType);
    }
}
