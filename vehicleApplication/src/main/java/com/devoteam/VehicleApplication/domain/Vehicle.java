package Devoteam.Checkpoints.vehicleApplication.src.main.java.com.devoteam.VehicleApplication.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public abstract class Vehicle implements VehicleInterface {
  private Automaker automaker;
  private String model;
  private String color;
  private int year;
  private VehicleTypeEnum vehicleType;
  private final String DATE_FORMATTER = "MMM dd, yyyy, HH:mm:ss";
  //JENS: Date dingen in eigen (helper) functie?
  LocalDateTime localDateTime = LocalDateTime.now();
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER, Locale.ENGLISH);
  private final String createdAt;
  //Zoek default parameter
  public Vehicle(Automaker automaker, String model, String color, int year, VehicleTypeEnum vehicleType) {
    this.setAutomaker(automaker);
    this.setModel(model);
    this.setColor(color);
    this.setYear(year);
    this.setVehicleType(vehicleType);
    this.createdAt = localDateTime.format(formatter);
  }

  public Vehicle(Automaker automaker, String model, String color, int year, VehicleTypeEnum vehicleType, String createdAt) {
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
  public String toString() {
    return "#------------------------------------------------# \n" +
        "Registration Date: " + createdAt + "\n" +
        automaker + "\n" +
        "Model: " + model + "\n" +
        "Vehicle type: " + vehicleType.vehicleType + "\n" +
        "Color: " + color + "\n" +
        "Year: " + year + "\n"
        ;
  }

  public void prettyPrint() {
    System.out.println(this.createdAt);
    System.out.println(this.automaker);
    System.out.println(this.model);
    System.out.println(this.color);
    System.out.println(this.year);
    System.out.println(this.vehicleType);
  }

}
