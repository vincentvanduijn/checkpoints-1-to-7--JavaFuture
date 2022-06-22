package Devoteam.Checkpoints.vehicleApplication.src.main.java.com.devoteam.VehicleApplication.service;


import Devoteam.Checkpoints.vehicleApplication.src.main.java.com.devoteam.VehicleApplication.domain.Automaker;
import Devoteam.Checkpoints.vehicleApplication.src.main.java.com.devoteam.VehicleApplication.domain.Vehicle;
import Devoteam.Checkpoints.vehicleApplication.src.main.java.com.devoteam.VehicleApplication.domain.VehicleTypeEnum;
import Devoteam.Checkpoints.vehicleApplication.src.main.java.com.devoteam.VehicleApplication.repository.VehicleRepository;

import java.util.ArrayList;

public class VehicleService {
    private static VehicleRepository vehicleRepository = new VehicleRepository();

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

    public ArrayList<Vehicle> searchByModelFilter(String autoModel, ArrayList<Vehicle> dataset) {
        ArrayList<Vehicle> filteredVehicleList = new ArrayList<Vehicle>();

        for (Vehicle currentItem : dataset) {
            if (currentItem.getModel().equals(autoModel)) {
                filteredVehicleList.add(currentItem);
            }

        }

        return filteredVehicleList;

    }

    public ArrayList<Vehicle> searchByColorFilter(String color, ArrayList<Vehicle> dataset) {
        ArrayList<Vehicle> filteredVehicleList = new ArrayList<Vehicle>();

        for (Vehicle currentItem : dataset) {
            if (currentItem.getColor().equals(color)) {
                filteredVehicleList.add(currentItem);
            }

        }

        return filteredVehicleList;
    }

    public ArrayList<Vehicle> searchByYearFilter(int year, ArrayList<Vehicle> dataset) {
        ArrayList<Vehicle> filteredVehicleList = new ArrayList<Vehicle>();

        for (Vehicle currentItem : dataset) {
            if (currentItem.getYear() == year) {
                filteredVehicleList.add(currentItem);
            }
        }
        return filteredVehicleList;
    }

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



    //JENS waarom een int returnen en niet gewoon de nieuwe vehicleModel zelf? Wat is de vehicleIndex?
    public int updateVehicleModel(String model) {
        ArrayList<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
        ArrayList<Vehicle> vehicleResponse = searchByModelFilter(model, vehicleList);

        if (vehicleResponse != null) {

            int vehicleIndex = vehicleList.indexOf(vehicleResponse);

            return vehicleIndex;
        } else {
            System.out.println("No vehicle with that model was found.");
            return -1;
        }
    }

    // public int updateVehicleColor(String color) {
    // Vehicle vehicleResponse = searchByColor(color);
    // System.out.println(vehicleResponse);

    // if (vehicleResponse != null) {
    // ArrayList<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
    // int vehicleIndex = vehicleList.indexOf(vehicleResponse);
    // return vehicleIndex;
    // } else {
    // System.out.println("No vehicle with that color was found.");
    // return -1;
    // }

    // }
    // public int updateVehicleYear(int year) {
    // Vehicle vehicleResponse = searchByYear(year);

    // if (vehicleResponse != null) {
    // ArrayList<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
    // int vehicleIndex = vehicleList.indexOf(vehicleResponse);
    // return vehicleIndex;
    // } else {
    // System.out.println("No vehicle with that year was found.");
    // return -1;
    // }
    // }

    public Boolean deleteVehicleByModel(String model) {
        ArrayList<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
        ArrayList<Vehicle> vehiclesFilteredByModel = searchByModelFilter(model, vehicleList);

        if (vehiclesFilteredByModel.size() > 1) {

        }

        // if (vehicleResponse != null) {
        //     ArrayList<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
        //     System.out.println(vehicleList);
        //     int vehicleIndex = vehicleList.indexOf(vehicleResponse);
        //     vehicleList.remove(vehicleIndex);
        //     return true;
        // } else {
        //     System.out.println("No vehicle with that model was found.");
        //     return false;
        // }
        return null;
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
    //JENS: Deze functie gebruik je nooit. Of weghalen of gebruiken
    public void deleteVehicleByIndex(int vehicleIndex) {
        vehicleRepository.getVehicleArray().remove(vehicleIndex);
    }

    public static Vehicle returnAllVehicleInIndex() {

        for (Vehicle item : vehicleRepository.getVehicleArray()) {
            System.out.println(item);

        }

        return null;
    }



}
