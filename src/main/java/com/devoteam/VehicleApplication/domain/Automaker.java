package main.java.com.devoteam.VehicleApplication.domain;

import java.util.Objects;
import java.util.UUID;

public class Automaker {
    private String name;
    private final UUID uuid = UUID.randomUUID();
    private final String id = uuid.toString();

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
        return "Automaker " +
                "name: " + name + '\n' +
                "Automaker ID: " + id
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Automaker automaker = (Automaker) o;
        return Objects.equals(id, automaker.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
