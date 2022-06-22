package Devoteam.Checkpoints.vehicleApplication.src.main.java.com.devoteam.VehicleApplication;

import Devoteam.Checkpoints.vehicleApplication.src.main.java.com.devoteam.VehicleApplication.domain.Automaker;
import Devoteam.Checkpoints.vehicleApplication.src.main.java.com.devoteam.VehicleApplication.domain.Vehicle;
import Devoteam.Checkpoints.vehicleApplication.src.main.java.com.devoteam.VehicleApplication.domain.VehicleTypeEnum;
import Devoteam.Checkpoints.vehicleApplication.src.main.java.com.devoteam.VehicleApplication.service.VehicleService;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleApplication {
  //JENS: Application niet in test - gebruik standaard JAVA structuur
//root/applicationname.src.main.java.resources/applicationpackage([com].[devoteam].[futures].[checkpoint4]).files & folders

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    boolean looping = true;
    VehicleService vehicleService = new VehicleService();

    while (looping) {

      System.out.println(" \n Choose your function: \n");
      System.out.println("1. Searh by automaker");
      System.out.println("2. Search by model ");
      System.out.println("3. Add vehicle ");
      System.out.println("4. Update vehicle ");
      System.out.println("5. Delete vehicle");
      System.out.println("6. Show all vehicles in the database");
      System.out.println("0. Exit Program");
      int automaker1 = input.nextInt();

      switch (automaker1) {
        case 1:
          System.out.println(" \n Choose your automaker brand: ");
          String automakerSelection = input.next();

          ArrayList<Vehicle> selectedVehicles = new ArrayList<Vehicle>();
          selectedVehicles = vehicleService.searchByAutomaker(automakerSelection);
          for (Vehicle vehicle : selectedVehicles) {
            System.out.println(vehicle);
          }
          break;

        case 2:
          System.out.println(" \n Choose your car model: ");
          String automakerSelection2 = input.next();
          Vehicle selectedModel;
          selectedModel = vehicleService.searchByModel(automakerSelection2);
          if (selectedModel == null) {
            System.out.println("This is not a valid option, please try again");
          } else {
            System.out.println(selectedModel);
          }

          break;

        case 3:
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
          break;

        case 4:
          System.out.println(" \n Choose what vehicle to update, ");
          System.out.println("Select a vehicle model to update:");
          String vehicleModelInputModel = input.next();
          System.out.println(" \n Select the corresponding color for the chosen model:");
          String vehicleModelInputColor = input.next();
          System.out.println(" \n Select the corresponding year for the chosen model:");
          Integer vehicleModelInputYear = input.nextInt();
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
            Automaker newVehicleAutomaker = new Automaker(newAutoMakerName);
            boolean vehicleTypeCheck = vehicleService.vehicleTypeExists(newVehicleType);
            if (vehicleTypeCheck) {
              Vehicle newVehicle = VehicleTypeEnum.valueOf(newVehicleType).createNewVehicle(newVehicleAutomaker,
                  newModel, newColor, newYear);
              Vehicle oldVehicle = vehicleService.searchByModel(vehicleModelInputModel);
              vehicleService.updateVehicle(oldVehicle, newVehicle);
            } else {
              System.out.println("Something went wrong, vehicle was not updated.");
            }
            break;
          } else {
            System.out.println("No vehicle found to update.");
          }
          break;

        case 5:
          System.out.println(" \n Choose what vehicle to delete, ");
          System.out.println(" \n Choose the model of the vehicle you want to delete: ");
          String modelToDelete = input.next();
          Boolean serviceResponse = vehicleService.deleteVehicleByModel(modelToDelete);
          if (serviceResponse) {
            System.out.println("Vehicle was deleted.");
          } else {
            System.out.println("Something went wrong, vehicle was not deleted.");
          }
          break;

        case 6:
        System.out.println(" \n List of all vehicles in the database: ");
        VehicleService.returnAllVehicleInIndex();
        break;


        case 0:
          looping = false;
          return;

        default:
          System.out.println("Please, select on of the above options");
      }

      while (true) {
        Scanner input2 = new Scanner(System.in);

        System.out.println("");
        System.out.println("Do you wish to continue? \n");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int continue1 = input2.nextInt();

        if (continue1 == 2) {
          looping = false;
          break;
        } else if (continue1 == 1) {
          break;
        } else {
          System.out.println("Please pick a valid option");
        }

      }

    }

  }

}