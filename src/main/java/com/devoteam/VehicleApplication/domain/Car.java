package main.java.com.devoteam.VehicleApplication.domain;


public class Car extends Vehicle {
    public Car(Automaker automaker, String model, String color, int year, VehicleTypeEnum vehicleType) {
        super(automaker, model, color, year, vehicleType);
    }
    public Car(Automaker automaker, String model, String color, int year, VehicleTypeEnum vehicleType, String createdAt) {
        super(automaker, model, color, year, vehicleType, createdAt);
    }
}
