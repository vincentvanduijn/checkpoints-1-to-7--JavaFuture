package main.java.com.devoteam.VehicleApplication.domain;

public class Automaker {
  private String name;

  public Automaker(String name) {
    this.setName(name);
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Automaker: " + name;
  }

}
