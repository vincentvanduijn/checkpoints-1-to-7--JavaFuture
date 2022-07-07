package main.java.com.devoteam.VehicleApplication.repository;

import main.java.com.devoteam.VehicleApplication.domain.Automaker;
import main.java.com.devoteam.VehicleApplication.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class AutomakerRepository {
    List<Automaker> automakerArray = new ArrayList<>();


    public void addToAutomakerArray(Automaker automaker) {
        automakerArray.add(automaker);
    }

    public Automaker getFromAutomakerArray (String automakerName) {
        for (Automaker item : automakerArray) {
            if (item.getName().equals(automakerName)) {
                return item;
            }
        }
        return null;
    }




}
