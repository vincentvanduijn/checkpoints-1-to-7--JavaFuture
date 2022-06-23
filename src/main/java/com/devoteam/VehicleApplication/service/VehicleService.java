package main.java.com.devoteam.VehicleApplication.service;

import main.java.com.devoteam.VehicleApplication.domain.Automaker;
import main.java.com.devoteam.VehicleApplication.domain.Vehicle;
import main.java.com.devoteam.VehicleApplication.domain.VehicleTypeEnum;
import main.java.com.devoteam.VehicleApplication.repository.VehicleRepository;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VehicleService {
    private static final VehicleRepository vehicleRepository = new VehicleRepository();
    Logger logger = Logger.getLogger(VehicleService.class.getName());

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

    public void addVehicle(String automakerName, String model, String color, int year, String vehicleType) {
        Automaker automaker1 = new Automaker(automakerName);
        boolean vehicleTypeCheck = vehicleTypeExists(vehicleType);
        if (!vehicleTypeCheck) {
            return;
        }

        Vehicle addedVehicle = VehicleTypeEnum.valueOf(vehicleType).createNewVehicle(automaker1, model, color, year);
        ArrayList<Vehicle> vehicleList;
        vehicleList = vehicleRepository.getVehicleArray();

        for (Vehicle item : vehicleRepository.getVehicleArray()) {
            if (item.getModel().equals(model)
                    && item.getVehicleType().equals(VehicleTypeEnum.valueOf(vehicleType))
                    && item.getAutomaker().getName().equals(automakerName)
                    && item.getColor().equals(color) && item.getYear() == year) {
                logger.log(Level.INFO,"This is a duplicate entry, please try again");
                return;
            }
        }

        vehicleList.add(addedVehicle);
        vehicleRepository.setVehicleArray(vehicleList);
        logger.log(Level.INFO,"Vehicle was updated");

    }

    public void updateVehicle(Vehicle oldVehicle, Vehicle newVehicle) {
        ArrayList<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
        int vehicleIndex = vehicleList.indexOf(oldVehicle);
        if (oldVehicle.getModel().equals(newVehicle.getModel())
                && oldVehicle.getVehicleType().equals(newVehicle.getVehicleType())
                && oldVehicle.getAutomaker().getName().equals(newVehicle.getAutomaker().getName())
                && oldVehicle.getColor().equals(newVehicle.getColor())
                && oldVehicle.getYear() == newVehicle.getYear()) {
            logger.log(Level.INFO,"The update you tried to pass is the same as an existing vehicle");
        } else {
            vehicleList.set(vehicleIndex, newVehicle);
            logger.log(Level.INFO,"Update confirmed");
        }
    }

    public int updateVehicleModel(String model) {
        ArrayList<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
        Vehicle vehicleResponse = searchByModel(model);

        if (vehicleResponse != null) {
            return vehicleList.indexOf(vehicleResponse);
        } else {
            logger.log(Level.INFO,"No vehicle with that model was found.");
            return -1;
        }
    }

    public Boolean deleteVehicleByModel(String model) {
        Vehicle vehicleResponse = searchByModel(model);
        if (vehicleResponse != null) {
            ArrayList<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
            System.out.println(vehicleList);
            vehicleList.remove(vehicleResponse);
            return true;
        } else {
            logger.log(Level.INFO,"No vehicle with that model was found.");
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
            logger.log(Level.INFO,"This is a non existing vehicle type, please try again");
            return false;
        } else {
            return true;
        }
    }

    public static void returnAllVehicleInIndex() {

        for (Vehicle item : vehicleRepository.getVehicleArray()) {
            System.out.println(item);

        }

    }



}
