package Devoteam.Checkpoints.checkpoint3.domain;

public abstract class Vehicle implements VehicleInterface {
  private Automaker automaker;
  private String model;
  private String color;
  private int year;
  private VehicleTypeEnum vehicleType;

  public Vehicle(Automaker automaker, String model, String color, int year, VehicleTypeEnum vehicleType) {
    this.setAutomaker(automaker);
    this.setModel(model);
    this.setColor(color);
    this.setYear(year);
    this.setVehicleType(vehicleType);
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
  public String toString() {
    return "{" +
        automaker + "'" +
        ", vehicle type='" + vehicleType.vehicleType + "'" +
        ", model='" + model + "'" +
        ", color='" + color + "'" +
        ", year='" + year + "'" +
        "}";
  }

  public void prettyPrint() {
    System.out.println(this.automaker);
    System.out.println(this.model);
    System.out.println(this.color);
    System.out.println(this.year);
    System.out.println(this.vehicleType);
  }

}
