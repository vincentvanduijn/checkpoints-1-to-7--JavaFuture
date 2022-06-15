package Devoteam.Checkpoints.checkpoint3.service;

import java.util.ArrayList;

import Devoteam.Checkpoints.checkpoint3.domain.Automaker;
import Devoteam.Checkpoints.checkpoint3.domain.Vehicle;
import Devoteam.Checkpoints.checkpoint3.domain.VehicleTypeEnum;
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

    // public Vehicle searchByColor(String color) {

    //     for (Vehicle item : vehicleRepository.getVehicleArray()) {
    //         if (item.getColor().equals(color)) {
    //             return item;
    //         }
    //     }
    //     return null;
    // }

    // public Vehicle searchByYear(int year) {

    //     for (Vehicle item : vehicleRepository.getVehicleArray()) {
    //         if (item.getYear() == year) {
    //             return item;
    //         }
    //     }
    //     return null;
    // }

    public Vehicle addVehicle(String automakerName, String model, String color, int year, String vehicleType) {
        Automaker automaker1 = new Automaker(automakerName);
        boolean vehicleTypeCheck = vehicleTypeExists(vehicleType);
        if (!vehicleTypeCheck) {
            return null;
        }

        Vehicle addedVehicle = VehicleTypeEnum.valueOf(vehicleType).createNewVehicle(automaker1, model, color, year);
        ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
        vehicleList = vehicleRepository.getVehicleArray();

        for (Vehicle item : vehicleRepository.getVehicleArray()) {
            if (item.getModel().equals(model)
                    && item.getVehicleType().equals(VehicleTypeEnum.valueOf(vehicleType))
                    && item.getAutomaker().getName().equals(automakerName)
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
                && oldVehicle.getVehicleType().equals(newVehicle.getVehicleType())
                && oldVehicle.getAutomaker().getName().equals(newVehicle.getAutomaker().getName())
                && oldVehicle.getColor().equals(newVehicle.getColor())
                && oldVehicle.getYear() == newVehicle.getYear()) {
            System.out.println("The update you tried to pass is the same as an existing vehicle");
        } else {
            vehicleList.set(vehicleIndex, newVehicle);
            System.out.println("Update confirmed");
        }
    }

    // updateVehicleModel ipv boolean returned het nu een int (de vehicleIndex)
    // TO DO: updateVehicleModel ombouwen naar updateVehicleModelColorYear, checken op de 3 waardes
    public int updateVehicleModel(String model) {
        Vehicle vehicleResponse = searchByModel(model);

        if (vehicleResponse != null) {
            ArrayList<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
            int vehicleIndex = vehicleList.indexOf(vehicleResponse);
            // de vehicleList.remove(vehicleIndex) weggehaald en vervangen door de vehicleIndex
            return vehicleIndex;
        } else {
            // -1 bestaat niet in de array dus returnen -1 ipv false
            System.out.println("No vehicle with that model was found.");
            return -1;
        }
    }

    // public int updateVehicleColor(String color) {
    //     Vehicle vehicleResponse = searchByColor(color);
    //     System.out.println(vehicleResponse);

    //     if (vehicleResponse != null) {
    //         ArrayList<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
    //         int vehicleIndex = vehicleList.indexOf(vehicleResponse);
    //         return vehicleIndex;
    //     } else {
    //         System.out.println("No vehicle with that color was found.");
    //         return -1;
    //     }

    // }
    // public int updateVehicleYear(int year) {
    //     Vehicle vehicleResponse = searchByYear(year);

    //     if (vehicleResponse != null) {
    //         ArrayList<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
    //         int vehicleIndex = vehicleList.indexOf(vehicleResponse);
    //         return vehicleIndex;
    //     } else {
    //         System.out.println("No vehicle with that year was found.");
    //         return -1;
    //     }
    // }

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

    public boolean vehicleTypeExists(String userVehicleType) {
        int tries = 0;
        for (int i = 0; i < VehicleTypeEnum.values().length; i++) {
            if (!VehicleTypeEnum.values()[i].name().equals(userVehicleType)) {
                tries++;
            }
        }
        if (tries == VehicleTypeEnum.values().length) {
            System.out.println("This is a non existing vehicle type, please try again");
            return false;
        } else {
            return true;
        }
    }

    public void deleteVehicleByIndex(int vehicleIndex) {
        vehicleRepository.getVehicleArray().remove(vehicleIndex);
    }

}
