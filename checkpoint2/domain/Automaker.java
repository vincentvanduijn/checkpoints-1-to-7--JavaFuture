package Devoteam.Checkpoints.checkpoint2.domain;

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
    return "AutomakerName='" + name;
  }

}
