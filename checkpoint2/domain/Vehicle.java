package Devoteam.Checkpoints.checkpoint2.domain;

public class Vehicle {
  private Automaker automaker;
  private String model;
  private String color;
  private int year;

  public Vehicle(Automaker automaker, String model, String color, int year) {
    this.setAutomaker(automaker);
    this.setModel(model);
    this.setColor(color);
    this.setYear(year);
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

  @Override
  public String toString() {
    return "{" +
        automaker + "'" +
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

  }

}
