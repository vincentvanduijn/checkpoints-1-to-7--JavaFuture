package Devoteam.Checkpoints.checkpoint3.domain;

  public enum VehicleEnum {
    CAR,
    MOTORCYCLE,
    VAN,
    TRUCK,
    PICKUP,
    OTHERS
}

public interface InnerVehicle {
    public getVehichleType() {
      return this.vehicleTypeEnum;
    }
  
}

