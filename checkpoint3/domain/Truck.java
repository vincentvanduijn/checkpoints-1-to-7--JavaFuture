package Devoteam.Checkpoints.checkpoint3.domain;

public class Truck extends Vehicle {

    public Truck(Automaker automaker, String model, String color, int year) {
        super(automaker, model, color, year);
    }

    @Override
    public VehicleTypeEnum getVehicleType() {
        return VehicleTypeEnum.TRUCK;
    }



}