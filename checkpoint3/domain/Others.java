package Devoteam.Checkpoints.checkpoint3.domain;

public class Others extends Vehicle {

    public Others(Automaker automaker, String model, String color, int year) {
        super(automaker, model, color, year);
    }

    @Override
    public VehicleTypeEnum getVehicleType() {
        return VehicleTypeEnum.OTHERS;
    }


}