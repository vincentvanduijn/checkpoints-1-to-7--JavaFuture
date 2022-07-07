package main.java.com.devoteam.VehicleApplication.domain;

public enum VehicleTypeEnum {
  CAR("CAR") {
    @Override
    public Vehicle buildNewVehicle(Automaker automaker, String model, String color, int year) {
      return new Car(automaker, model, color, year, CAR);
    }
  },
  MOTORCYCLE("MOTORCYCLE") {
    @Override
    public Vehicle buildNewVehicle(Automaker automaker, String model, String color, int year) {
      return new Motorcycle(automaker, model, color, year, MOTORCYCLE);
    }
  },

  VAN("VAN") {
    @Override
    public Vehicle buildNewVehicle(Automaker automaker, String model, String color, int year) {
      return new Van(automaker, model, color, year, VAN);
    }
  },

  TRUCK("TRUCK") {
    @Override
    public Vehicle buildNewVehicle(Automaker automaker, String model, String color, int year) {
      return new Truck(automaker, model, color, year, TRUCK);
    }
  },

  PICKUP("PICKUP") {
    @Override
    public Vehicle buildNewVehicle(Automaker automaker, String model, String color, int year) {
      return new Pickup(automaker, model, color, year, PICKUP);
    }
  },

  OTHERS("OTHERS") {
    @Override
    public Vehicle buildNewVehicle(Automaker automaker, String model, String color, int year) {
      return new Others(automaker, model, color, year, OTHERS);
    }
  };

  public final String vehicleType;

  VehicleTypeEnum(String vehicleType) {
    this.vehicleType = vehicleType;
  }

  public abstract Vehicle buildNewVehicle(Automaker automaker, String model, String color, int year);

}
