package main.java.com.devoteam.VehicleApplication.service;

import main.java.com.devoteam.VehicleApplication.domain.Automaker;
import main.java.com.devoteam.VehicleApplication.domain.Vehicle;
import main.java.com.devoteam.VehicleApplication.domain.VehicleTypeEnum;
import main.java.com.devoteam.VehicleApplication.repository.AutomakerRepository;
import main.java.com.devoteam.VehicleApplication.repository.VehicleRepository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VehicleService {

    private static final AutomakerRepository automakerRepository = new AutomakerRepository();
    private static final VehicleRepository vehicleRepository = new VehicleRepository(automakerRepository);

    Logger logger = Logger.getLogger(VehicleService.class.getName());

    public static void returnAllVehicleInIndex() {

        for (Vehicle item : vehicleRepository.getVehicleArray()) {
            System.out.println(item);

        }

    }

    public List<Vehicle> searchByAutomaker(String autoMaker) {

        return vehicleRepository.getVehicleArray().stream()
                .filter(searchByAutomaker -> searchByAutomaker.getAutomaker().getName().equals(autoMaker))
                .toList();
    }

    public List<Vehicle> searchByModel(String autoModel) {
        return vehicleRepository.getVehicleArray().stream()
                .filter(searchByModel -> searchByModel.getModel().equals(autoModel))
                .toList();
    }

    public void addVehicle(String automakerName, String model, String color, int year, String vehicleType) {
        Automaker findAutomakerBrand = getExistingAutomaker(automakerName);

        if (findAutomakerBrand == null) {
            logger.log(Level.INFO, "This is not a valid automaker");
            return;
        }
        boolean vehicleTypeCheck = vehicleTypeExists(vehicleType);
        if (!vehicleTypeCheck) {
            return;
        }
        Vehicle addedVehicle = VehicleTypeEnum.valueOf(vehicleType).buildNewVehicle(findAutomakerBrand, model, color, year);
        List<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
        for (Vehicle item : vehicleRepository.getVehicleArray()) {
            if (item.getModel().equals(model)
                    && item.getVehicleType().equals(VehicleTypeEnum.valueOf(vehicleType))
                    && item.getAutomaker().getName().equals(automakerName)
                    && item.getColor().equals(color)
                    && item.getYear() == year) {
                logger.log(Level.INFO, "This is a duplicate entry, please try again");
                return;
            }
        }
        vehicleList.add(addedVehicle);
        vehicleRepository.setVehicleArray(vehicleList);
        System.out.println("Vehicle was added");
    }

    public void updateVehicle(Vehicle existingVehicle, Automaker automaker, String model, String color, int year, VehicleTypeEnum vehicleType) {
        existingVehicle.setAutomaker(automaker);
        existingVehicle.setModel(model);
        existingVehicle.setColor(color);
        existingVehicle.setYear(year);
        existingVehicle.setVehicleType(vehicleType);
        System.out.println("Update confirmed");
    }

    public boolean vehicleModelExists(String model) {
        List<Vehicle> vehicleResponse = searchByModel(model);

        if (!vehicleResponse.isEmpty()) {
            return true;
        } else {
            logger.log(Level.INFO, "No vehicle with that model was found.");
            return false;
        }
    }

    public boolean deleteVehicleByModel(String model) {
        List<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
        List<Vehicle> vehicleResponse = searchByModel(model);
        if (vehicleResponse.isEmpty()) {
            logger.log(Level.INFO, "No vehicle with that model was found.");
            return false;
        }
        vehicleResponse.forEach(vehicleList::remove);
        return true;

    }

    public boolean vehicleTypeExists(String userVehicleType) {

        for (VehicleTypeEnum i : VehicleTypeEnum.values()) {
            if (i.name().equals(userVehicleType)) {
                return true;
            }
        }

        logger.log(Level.INFO, "This is a non existing vehicle type, please try again");
        return false;

    }


    public Automaker getExistingAutomaker(String automakerName) {
        return automakerRepository.getFromAutomakerArray(automakerName);
    }


}
