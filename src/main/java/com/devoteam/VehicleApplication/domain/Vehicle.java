package main.java.com.devoteam.VehicleApplication.domain;

import java.util.Objects;
import java.util.UUID;

public abstract class Vehicle implements VehicleInterface {
  private Automaker automaker;
  private String model;
  private String color;
  private int year;
  private VehicleTypeEnum vehicleType;
  private final String createdAt;
  private final UUID uuid = UUID.randomUUID();
  private final String id = uuid.toString();

  protected Vehicle(Automaker automaker, String model, String color, int year, VehicleTypeEnum vehicleType) {
    this.setAutomaker(automaker);
    this.setModel(model);
    this.setColor(color);
    this.setYear(year);
    this.setVehicleType(vehicleType);
    this.createdAt = DateFormater.localDateTime.format(DateFormater.formatter);
  }

  protected Vehicle(Automaker automaker, String model, String color, int year, VehicleTypeEnum vehicleType, String createdAt) {
    this.setAutomaker(automaker);
    this.setModel(model);
    this.setColor(color);
    this.setYear(year);
    this.setVehicleType(vehicleType);
    this.createdAt = createdAt;

  }


  public Automaker getAutomaker() {
    return this.automaker;
  }

  public void setAutomaker(Automaker automaker) {
    this.automaker = automaker;
  }

  public String getModel() {
    return this.model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getYear() {
    return this.year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public VehicleTypeEnum getVehicleType() {
    return this.vehicleType;
  }

  public void setVehicleType(VehicleTypeEnum vehicleType) {
    this.vehicleType = vehicleType;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(id, vehicle.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "#------------------------------------------------# \n" +
            "Registration Date: " + createdAt + "\n" +
            automaker + "\n" +
            "Model: " + model + "\n" +
            "Id Vehicle='" + id + '\n' +
            "Vehicle type: " + vehicleType + "\n" +
            "Color: " + color + "\n" +
            "Year: " + year + "\n"
            ;
  }

}
