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

    public List<Vehicle> searchByAutomaker(String autoMaker) {
        return vehicleRepository.getVehicleArray().stream()
                .filter(sam -> sam.getAutomaker().getName().equals(autoMaker))
                .toList();
    }

     public List<Vehicle> searchByModel(String autoModel) {
         return vehicleRepository.getVehicleArray().stream()
                 .filter(sbm -> sbm.getModel().equals(autoModel))
                 .toList();
     }


    public void addVehicle(String automakerName, String model, String color, int year, String vehicleType) {
        Automaker automaker1 = getExistingAutomaker(automakerName);
        if (automaker1 == null) {
            logger.log(Level.INFO, "This is not a valid automaker");
            return;
        }
        boolean vehicleTypeCheck = vehicleTypeExists(vehicleType);
        if (!vehicleTypeCheck) {
            return;
        }
        Vehicle addedVehicle = VehicleTypeEnum.valueOf(vehicleType).buildNewVehicle(automaker1, model, color, year);
        List<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
        for (Vehicle item : vehicleRepository.getVehicleArray()) {
            if (item.getModel().equals(model)
                    && item.getVehicleType().equals(VehicleTypeEnum.valueOf(vehicleType))
                    && item.getAutomaker().getName().equals(automakerName)
                    && item.getColor().equals(color)
                    && item.getYear() == year) {
                logger.log(Level.INFO,"This is a duplicate entry, please try again");
                return;
            }
        }
        vehicleList.add(addedVehicle);
        vehicleRepository.setVehicleArray(vehicleList);
        System.out.println("Vehicle was added");
    }

    public void updateVehicle(Vehicle oldVehicle, Vehicle newVehicle) {
       List<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
        int vehicleIndex = vehicleList.indexOf(oldVehicle);
        if (oldVehicle.getModel().equals(newVehicle.getModel())
                && oldVehicle.getVehicleType().equals(newVehicle.getVehicleType())
                && oldVehicle.getAutomaker().getName().equals(newVehicle.getAutomaker().getName())
                && oldVehicle.getColor().equals(newVehicle.getColor())
                && oldVehicle.getYear() == newVehicle.getYear()) {
            logger.log(Level.INFO,"The update you tried to pass is the same as an existing vehicle");
        } else {
            vehicleList.set(vehicleIndex, newVehicle);
            System.out.println("Update confirmed");
        }
    }

    public int updateVehicleModel(String model) {
        List<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
        List<Vehicle> vehicleResponse = searchByModel(model);

        if (!vehicleResponse.isEmpty()) {
            Vehicle vehicleResponseObject = vehicleResponse.get(0);
            return vehicleList.indexOf(vehicleResponseObject);
        } else {
            logger.log(Level.INFO,"No vehicle with that model was found.");
            return -1;
        }
    }

    public Boolean deleteVehicleByModel(String model) {
        List<Vehicle> vehicleList = vehicleRepository.getVehicleArray();
        List<Vehicle> vehicleResponse = searchByModel(model);
        if (!vehicleResponse.isEmpty()) {
            for (Vehicle vehicle : vehicleResponse) {
                System.out.println(vehicle);
                vehicleList.remove(vehicle);
            }
            return true;
        } else {
            logger.log(Level.INFO,"No vehicle with that model was found.");
            return false;
        }

    }

    public boolean vehicleTypeExists(String userVehicleType) {
        int tries = 0;
        for (VehicleTypeEnum i : VehicleTypeEnum.values()) {
            if (!i.name().equals(userVehicleType)) {
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

    public Automaker getExistingAutomaker(String automakerName) {
        Automaker foundAutomaker = automakerRepository.getFromAutomakerArray(automakerName);
        if (foundAutomaker == null) {
            return null;
        } else {
            return foundAutomaker;
        }
    }



}
