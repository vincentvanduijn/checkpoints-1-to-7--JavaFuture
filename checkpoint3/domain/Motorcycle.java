package Devoteam.Checkpoints.checkpoint3.domain;

public class Motorcycle extends Vehicle {

    public Motorcycle(Automaker automaker, String model, String color, int year) {
        super(automaker, model, color, year);
    }

    @Override
    public VehicleTypeEnum getVehicleType() {
        return VehicleTypeEnum.MOTORCYCLE;
    }



}