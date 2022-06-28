package main.java.com.devoteam.VehicleApplication;


import main.java.com.devoteam.VehicleApplication.domain.Automaker;
import main.java.com.devoteam.VehicleApplication.domain.Vehicle;
import main.java.com.devoteam.VehicleApplication.domain.VehicleTypeEnum;
import main.java.com.devoteam.VehicleApplication.service.VehicleService;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VehicleApplication {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    Logger logger = Logger.getLogger(VehicleApplication.class.getName());
    boolean looping = true;
    VehicleService vehicleService = new VehicleService();

    while (looping) {

      logger.log(Level.INFO, " \n Choose your function: \n");
      logger.log(Level.INFO,"1. Search by automaker");
      logger.log(Level.INFO,"2. Search by model ");
      logger.log(Level.INFO,"3. Add vehicle ");
      logger.log(Level.INFO,"4. Update vehicle ");
      logger.log(Level.INFO,"5. Delete vehicle");
      logger.log(Level.INFO,"6. Show all vehicles in the database");
      logger.log(Level.INFO,"0. Exit Program");
      int automaker1 = input.nextInt();

      switch (automaker1) {
        case 1 -> {
          logger.log(Level.INFO, " \n Choose your automaker brand: ");
          String automakerSelection = input.next();
          ArrayList<Vehicle> selectedVehicles;
          selectedVehicles = vehicleService.searchByAutomaker(automakerSelection);
          for (Vehicle vehicle : selectedVehicles) {
            System.out.println(vehicle);
          }
        }
        case 2 -> {
          logger.log(Level.INFO," \n Choose your car model: ");
          String automakerSelection2 = input.next();
          Vehicle selectedModel;
          selectedModel = vehicleService.searchByModel(automakerSelection2);
          if (selectedModel == null) {
            logger.log(Level.INFO,"This is not a valid option, please try again");
          } else {
            System.out.println(selectedModel);
          }
        }
        case 3 -> {
          logger.log(Level.INFO," \n Choose what vehicle to add, ");
          logger.log(Level.INFO," \n Choose automaker name: ");
          String autoMakerName = input.next();
          logger.log(Level.INFO," \n Choose the vehicle type: ");
          String vehicleType = input.next();
          logger.log(Level.INFO," \n Choose model: ");
          String model = input.next();
          logger.log(Level.INFO," \n Choose color: ");
          String color = input.next();
          logger.log(Level.INFO," \n Choose year: ");
          int year = input.nextInt();
          vehicleService.addVehicle(autoMakerName, model, color, year, vehicleType);
        }
        case 4 -> {
          logger.log(Level.INFO," \n Choose what vehicle to update, ");
          logger.log(Level.INFO,"Select a vehicle model to update:");
          String vehicleModelInputModel = input.next();
          int updateResponseIndex = vehicleService.updateVehicleModel(vehicleModelInputModel);
          if (updateResponseIndex > 0) {
            logger.log(Level.INFO," \n Choose automaker name: ");
            String newAutoMakerName = input.next();
            logger.log(Level.INFO," \n Choose the vehicle type: ");
            String newVehicleType = input.next();
            logger.log(Level.INFO," \n Choose model: ");
            String newModel = input.next();
            logger.log(Level.INFO," \n Choose color: ");
            String newColor = input.next();
            logger.log(Level.INFO," \n Choose year: ");
            int newYear = input.nextInt();
            Automaker newVehicleAutomaker = new Automaker(newAutoMakerName);
            boolean vehicleTypeCheck = vehicleService.vehicleTypeExists(newVehicleType);
            if (vehicleTypeCheck) {
              Vehicle newVehicle = VehicleTypeEnum.valueOf(newVehicleType).createNewVehicle(newVehicleAutomaker,
                      newModel, newColor, newYear);
              Vehicle oldVehicle = vehicleService.searchByModel(vehicleModelInputModel);
              vehicleService.updateVehicle(oldVehicle, newVehicle);
            } else {
              logger.log(Level.INFO,"Something went wrong, vehicle was not updated.");
            }
          } else {
            logger.log(Level.INFO,"No vehicle found to update.");
          }
        }
        case 5 -> {
          logger.log(Level.INFO," \n Choose what vehicle to delete, ");
          logger.log(Level.INFO," \n Choose the model of the vehicle you want to delete: ");
          String modelToDelete = input.next();
          Boolean serviceResponse = vehicleService.deleteVehicleByModel(modelToDelete);
          if (Boolean.TRUE.equals(serviceResponse)) {
            logger.log(Level.INFO,"Vehicle was deleted.");
          } else {
            logger.log(Level.INFO,"Something went wrong, vehicle was not deleted.");
          }
        }
        case 6 -> {
          logger.log(Level.INFO," \n List of all vehicles in the database: ");
          VehicleService.returnAllVehicleInIndex();
        }
        case 0 -> {
          return;
        }
        default -> logger.log(Level.INFO,"Please, select on of the above options");
      }

      while (true) {
        Scanner input2 = new Scanner(System.in);

        logger.log(Level.INFO,"Do you wish to continue? \n");
        logger.log(Level.INFO,"1. Yes");
        logger.log(Level.INFO,"2. No");

        int continue1 = input2.nextInt();

        if (continue1 == 2) {
          looping = false;
          break;
        } else if (continue1 == 1) {
          break;
        } else {
          logger.log(Level.INFO,"Please pick a valid option");
        }

      }

    }

  }

}