package Devoteam.Checkpoints.checkpoint3.service;

import java.util.ArrayList;

import Devoteam.Checkpoints.checkpoint3.domain.Automaker;
import Devoteam.Checkpoints.checkpoint3.domain.Car;
import Devoteam.Checkpoints.checkpoint3.domain.Vehicle;
import Devoteam.Checkpoints.checkpoint3.repository.VehicleRepository;

public class VehicleService {
    private VehicleRepository vehicleRepository = new VehicleRepository();

    public ArrayList<Vehicle> searchByAutomaker(String autoMaker) {
        ArrayList<Vehicle> newArray = new ArrayList<Vehicle>();

        for (Vehicle item : vehicleRepository.getVehicleArray()) {
            if (item.getAutomaker().getName().equals(autoMaker)) {
                newArray.add(item);
            }
        }

        return newArray;
    }

    public Vehicle searchByModel(String autoModel) {

        for (Vehicle item : vehicleRepository.getVehicleArray()) {
            if (item.getModel().equals(autoModel)) {
                return item;
            }
        }
        return null;
    }

    public Vehicle addVehicle(String automakerName, String model, String color, int year) {
        Automaker automaker1 = new Automaker(automakerName);
        Vehicle addedVehicle = new Car(automaker1, model, color, year);
        ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
        vehicleList = vehicleRepository.getVehicleArray();

        for (Vehicle item : vehicleRepository.getVehicleArray()) {
            if (item.getModel().equals(model) && item.getAutomaker().getName().equals(automakerName)
                    && item.getColor().equals(color) && item.getYear() == year) {
                System.out.println("This is a duplicate entry, please try again");
                return item;
            }
        }

        vehicleList.add(addedVehicle);
        vehicleRepository.setVehicleArray(vehicleList);
        return addedVehicle;

    }

    public void updateVehicle(Vehicle oldVehicle, Vehicle newVehicle) {
        ArrayList<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
        int vehicleIndex = vehicleList.indexOf(oldVehicle);
        if (oldVehicle.getModel().equals(newVehicle.getModel())
                && oldVehicle.getAutomaker().getName().equals(newVehicle.getAutomaker().getName())
                && oldVehicle.getColor().equals(newVehicle.getColor())
                && oldVehicle.getYear() == newVehicle.getYear()) {
            System.out.println("The update you tried to pass is the same as an existing vehicle");
        } else {
            vehicleList.set(vehicleIndex, newVehicle);
            System.out.println("Update confirmed");
        }
    }
    public Boolean updateVehicleModel(String model) {
        Vehicle vehicleResponse = searchByModel(model);
        if (vehicleResponse != null) {
            ArrayList<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
            int vehicleIndex = vehicleList.indexOf(vehicleResponse);
            vehicleList.remove(vehicleIndex);
            return true;
        } else {
            System.out.println("No vehicle with that model was found.");
            return false;
        }
    }


    public Boolean deleteVehicleByModel(String model) {
        Vehicle vehicleResponse = searchByModel(model);
        if (vehicleResponse != null) {
            ArrayList<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
            int vehicleIndex = vehicleList.indexOf(vehicleResponse);
            vehicleList.remove(vehicleIndex);
            return true;
        } else {
            System.out.println("No vehicle with that model was found.");
            return false;
        }
    }

}
