package Devoteam.Checkpoints.checkpoint3.domain;

public class Pickup extends Vehicle {

    public Pickup(Automaker automaker, String model, String color, int year, VehicleTypeEnum vehicleType) {
        super(automaker, model, color, year, vehicleType);
    }

    @Override
    public VehicleTypeEnum getVehicleType() {
        return VehicleTypeEnum.PICKUP;
    }

}