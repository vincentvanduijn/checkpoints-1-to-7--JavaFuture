package com.devoteam.VehicleApplication.service;

import com.devoteam.VehicleApplication.domain.Automaker;
import com.devoteam.VehicleApplication.domain.Vehicle;
import com.devoteam.VehicleApplication.domain.VehicleTypeEnum;
import com.devoteam.VehicleApplication.repository.AutomakerRepository;
import com.devoteam.VehicleApplication.repository.VehicleRepository;
import lombok.extern.log4j.Log4j2;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@Log4j2
public class ApplicationService {
    Scanner input = new Scanner(System.in);
    Logger logger = Logger.getLogger(ApplicationService.class.getName());

    public void menuLogic() {
        log.info("\n Choose your function: \n");
        log.info("1. Search by automaker");
        log.info("2. Search by model ");
        log.info("3. Add vehicle ");
        log.info("4. Update vehicle ");
        log.info("5. Delete vehicle");
        log.info("6. Show all vehicles in the database");
        log.info("0. Exit Program");
    }

    public void switch1Logic() {
        log.info(" \n Choose your automaker brand: ");
        List<Vehicle> selectedVehicles = VehicleRepository.findByNameAutomaker(String.valueOf(input.next()));
        String formattedSelectedVehicles = outputStringFormatter(String.valueOf(selectedVehicles));
        if (selectedVehicles.isEmpty()) {
            logger.log(Level.WARNING, "No automaker brand found with this name, or no existing vehicles from automaker in database. Please try again");
        } else {
            log.info("\n" + formattedSelectedVehicles + "\n");
        }
    }

    public void switch2Logic() {
        log.info(" \n Choose your vehicle model: ");
        List<Vehicle> selectedModel = VehicleRepository.findByNameModel(String.valueOf(input.next()));
        String formattedSelectedModel = outputStringFormatter(String.valueOf(selectedModel));
        if (selectedModel.isEmpty()) {
            logger.log(Level.WARNING, "No vehicles found with this model name, please try again");
        } else {
            log.info("\n" + formattedSelectedModel + "\n");
        }
    }

    public void switch3Logic() {
        log.info(" \n Insert the information of the vehicle you want to save in the database: ");
        Automaker newAutomaker = checkingForAutomaker();
        log.info(" \n Choose model: ");
        String saveModel = input.next();
        log.info(" \n Choose color: ");
        String saveColor = input.next();
        log.info(" \n Choose year: ");
        int saveYear = input.nextInt();
        log.info(" \n Choose the vehicle type: ");
        String saveVehicleType = input.next();
        Date saveDate = new Date();
        Vehicle vehicleToSave = buildVehicleToSave(newAutomaker, saveModel, saveColor, saveYear, saveVehicleType, saveDate);
        vehicleToSave.setId(VehicleRepository.saveVehicle(vehicleToSave));
        String formattedSavedModel = outputStringFormatter(String.valueOf(vehicleToSave));
        log.info("\n" + formattedSavedModel + "\n");
        log.info("Vehicle model was saved in the database");
    }

    private Vehicle buildVehicleToSave(Automaker newAutomaker, String saveModel, String saveColor, int saveYear, String saveVehicleType, Date saveDate) {
        return Vehicle.builder()
                .automaker(newAutomaker)
                .model(saveModel)
                .color(saveColor)
                .year(saveYear)
                .vehicleType(VehicleTypeEnum.valueOf(saveVehicleType))
                .createdOn(saveDate)
                .build();
    }

    public void switch4Logic() {
        log.info(" \n Choose what vehicle to update: ");
        List<Vehicle> modelExists = VehicleRepository.findByNameModel(String.valueOf(input.next()));
        String formattedSelectedVehicles = outputStringFormatter(String.valueOf(modelExists));
        if (modelExists.isEmpty()) {
            logger.log(Level.WARNING, "No vehicles found to update with this model name, please try again");
        } else {
            log.info("\n" + formattedSelectedVehicles + "\n");
            updatedVehicleBuilder(modelExists);
        }
    }

    private void updatedVehicleBuilder(List<Vehicle> vehicleList) {
        log.info("Choose the ID of the vehicle you wish to update");
        int idChosenVehicleToUpdate = input.nextInt();
        List<Vehicle> filteredVehicleList = vehicleList.stream()
                .filter(vehicle -> vehicle.getId() == idChosenVehicleToUpdate)
                .toList();
        if (filteredVehicleList.isEmpty()) {
            log.info("No vehicle model with the combination of ID and model name was found");
        } else {
            Vehicle vehicle = filteredVehicleList.get(0);
            log.info(" \n Updating the database");
            Automaker newAutomaker = checkingForAutomaker();
            log.info(" \n Choose model: ");
            String newModel = input.next();
            log.info(" \n Choose color: ");
            String newColor = input.next();
            log.info(" \n Choose year: ");
            int newYear = input.nextInt();
            log.info(" \n Choose the vehicle type: ");
            String newVehicleType = input.next();
            Date newDate = new Date();
            Vehicle vehicleToUpdate = buildVehicleToUpdate(vehicle, newAutomaker, newModel, newColor, newYear, newVehicleType, newDate);
            VehicleRepository.replaceVehicle(vehicleToUpdate);
            String formattedUpdatedModel = outputStringFormatter(String.valueOf(vehicleToUpdate));
            log.info("\n" + formattedUpdatedModel + "\n");
        }
    }

    private Vehicle buildVehicleToUpdate(Vehicle vehicle, Automaker newAutomaker, String newModel, String newColor, int newYear, String newVehicleType, Date newDate) {
        return Vehicle.builder()
                .model(vehicle.getModel())
                .automaker(newAutomaker)
                .model(newModel)
                .color(newColor)
                .year(newYear)
                .vehicleType(VehicleTypeEnum.valueOf(newVehicleType))
                .createdOn(newDate)
                .id(vehicle.getId())
                .build();
    }

    public Automaker checkingForAutomaker() {
        log.info(" \n Choose automaker: ");
        String automaker = input.next();
        List<Automaker> automakerExists = AutomakerRepository.findByName(automaker);
        if (automakerExists.isEmpty()) {
            log.info("No automaker found with that name. Creating new automaker");
            AutomakerRepository.saveAutomaker(automaker);
            automakerExists = AutomakerRepository.findByName(automaker);
            return automakerExists.get(0);
        } else {
            return automakerExists.get(0);
        }
    }

    public void switch5Logic() {
        log.info(" \n Choose the model of the vehicle you want to delete: ");
        String modelToDelete = input.next();
        List<Vehicle> selectedModelToDelete = VehicleRepository.findByNameModel(modelToDelete);
        String formattedSelectedVehicles = outputStringFormatter(String.valueOf(selectedModelToDelete));
        log.info("\n" + formattedSelectedVehicles + "\n");
        if (selectedModelToDelete.isEmpty()) {
            logger.log(Level.WARNING, "No vehicles found with this model name, please try again");
        } else {
            log.info("Choose the ID of the vehicle you wish to delete");
            int idChosenVehicleToUpdate = input.nextInt();
            List<Vehicle> filteredVehicleList = selectedModelToDelete.stream()
                    .filter(vehicle -> vehicle.getId() == idChosenVehicleToUpdate)
                    .toList();
            if (filteredVehicleList.isEmpty()) {
                log.info("No vehicle model with the combination of ID and model name was found");
            } else {
                Vehicle vehicle = filteredVehicleList.get(0);
                VehicleRepository.removeVehicleByModel(vehicle);
                log.info("Vehicle was deleted");
            }
        }
    }

    public void switch6Logic() {
        log.info(" \n List of all vehicles in the database: ");
        List<Vehicle> allVehicles = VehicleRepository.findAllVehicles();
        String formattedAllVehicles = outputStringFormatter(String.valueOf(allVehicles));
        log.info("\n" + formattedAllVehicles + "\n");
    }

    public String outputStringFormatter(String listFormatter) {
        return listFormatter
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .trim();
    }
}