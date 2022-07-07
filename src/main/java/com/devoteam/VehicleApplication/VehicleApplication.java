package main.java.com.devoteam.VehicleApplication;


import main.java.com.devoteam.VehicleApplication.domain.Automaker;
import main.java.com.devoteam.VehicleApplication.domain.Vehicle;
import main.java.com.devoteam.VehicleApplication.domain.VehicleTypeEnum;
import main.java.com.devoteam.VehicleApplication.service.VehicleService;

import java.util.ArrayList;
import java.util.List;
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

      System.out.println(" \n Choose your function: \n");
      System.out.println("1. Search by automaker");
      System.out.println("2. Search by model ");
      System.out.println("3. Add vehicle ");
      System.out.println("4. Update vehicle ");
      System.out.println("5. Delete vehicle");
      System.out.println("6. Show all vehicles in the database");
      System.out.println("0. Exit Program");
      int automakerMenuChoice = input.nextInt();

      switch (automakerMenuChoice) {
        case 1 -> {
          System.out.println(" \n Choose your automaker brand: ");
          String automakerSelection = input.next();
          List<Vehicle> selectedVehicles = new ArrayList<>();
          selectedVehicles = vehicleService.searchByAutomaker(automakerSelection);
          if (selectedVehicles == null || selectedVehicles.isEmpty()) {
            logger.log(Level.INFO, "This is not a valid option, please try again");
          }else {
            for (Vehicle vehicle : selectedVehicles) {
            System.out.println(vehicle);
          }

          }
        }
        case 2 -> {
          System.out.println(" \n Choose your car model: ");
          String automakerModelSelection = input.next();
          List<Vehicle> selectedModel = new ArrayList<>();
          selectedModel = vehicleService.searchByModel(automakerModelSelection);
          if (selectedModel == null || selectedModel.isEmpty()) {
            logger.log(Level.INFO,"This is not a valid option, please try again");
          } else {
            System.out.println(selectedModel);
          }
        }
        case 3 -> {
          System.out.println(" \n Choose what vehicle to add, ");
          System.out.println(" \n Choose automaker name: ");
          String autoMakerName = input.next();
          System.out.println(" \n Choose the vehicle type: ");
          String vehicleType = input.next();
          System.out.println(" \n Choose model: ");
          String model = input.next();
          System.out.println(" \n Choose color: ");
          String color = input.next();
          System.out.println(" \n Choose year: ");
          int year = input.nextInt();
          vehicleService.addVehicle(autoMakerName, model, color, year, vehicleType);
        }
        case 4 -> {
          System.out.println(" \n Choose what vehicle to update, ");
          System.out.println("Select a vehicle model to update:");
          String vehicleModelInputModel = input.next();
          int updateResponseIndex = vehicleService.updateVehicleModel(vehicleModelInputModel);
          if (updateResponseIndex > 0) {
            System.out.println(" \n Choose automaker name: ");
            String newAutoMakerName = input.next();
            System.out.println(" \n Choose the vehicle type: ");
            String newVehicleType = input.next();
            System.out.println(" \n Choose model: ");
            String newModel = input.next();
            System.out.println(" \n Choose color: ");
            String newColor = input.next();
            System.out.println(" \n Choose year: ");
            int newYear = input.nextInt();
            Automaker newVehicleAutomaker = vehicleService.getExistingAutomaker(newAutoMakerName);
            if (newVehicleAutomaker == null) {
              logger.log(Level.INFO,"No automaker found with the given name.");
              break;
            }
            boolean vehicleTypeCheck = vehicleService.vehicleTypeExists(newVehicleType);
            if (vehicleTypeCheck) {
              Vehicle newVehicle = VehicleTypeEnum.valueOf(newVehicleType).buildNewVehicle(newVehicleAutomaker,
                      newModel, newColor, newYear);
              List<Vehicle> oldVehicle = vehicleService.searchByModel(vehicleModelInputModel);
              vehicleService.updateVehicle((Vehicle) oldVehicle, newVehicle);
            } else {
              logger.log(Level.INFO,"Something went wrong, vehicle was not updated.");
            }
          } else {
            logger.log(Level.INFO,"No vehicle found to update.");
          }
        }
        case 5 -> {
          System.out.println(" \n Choose what vehicle to delete, ");
          System.out.println(" \n Choose the model of the vehicle you want to delete: ");
          String modelToDelete = input.next();
          Boolean serviceResponse = vehicleService.deleteVehicleByModel(modelToDelete);
          if (Boolean.TRUE.equals(serviceResponse)) {
            System.out.println("Vehicle was deleted.");
          } else {
            logger.log(Level.INFO,"Something went wrong, vehicle was not deleted.");
          }
        }
        case 6 -> {
          System.out.println(" \n List of all vehicles in the database: ");
          VehicleService.returnAllVehicleInIndex();
        }
        case 0 -> {
          return;
        }
        default -> System.out.println("Please, select on of the above options");
      }

      while (true) {
        Scanner input2 = new Scanner(System.in);

        System.out.println("Do you wish to continue? \n");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int continueWithApplication = input2.nextInt();

        if (continueWithApplication == 2) {
          looping = false;
          break;
        } else if (continueWithApplication == 1) {
          break;
        } else {
          logger.log(Level.INFO,"Please pick a valid option");
        }

      }

    }

  }

}