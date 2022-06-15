package Devoteam.Checkpoints.checkpoint3.test;

import java.util.ArrayList;
import java.util.Scanner;

import Devoteam.Checkpoints.checkpoint3.domain.Automaker;
import Devoteam.Checkpoints.checkpoint3.domain.Vehicle;
import Devoteam.Checkpoints.checkpoint3.domain.VehicleTypeEnum;
import Devoteam.Checkpoints.checkpoint3.service.VehicleService;

// --------15-6-2022------------
// Aangepast: laatste 2 punten van checkpoint 3 (zie o.a. VehicleTypeEnum)
// Aangepast: comments neer zetten bij changes ANDERS VERGEET JE WEER WAT JE GEDAAN HEBT!!!!
// Aangepast: in de vehicleservice bij de "dulpicate entry code" de lines voor vehicletype toegevoegd
// Aangepast: alle verouderde imports verwijdert
// BUGFIX: dat "old vehicle" een null waarde terug gaf
// BUGFIX: dat met de nieuwe code vehicleIndex al was verwijderd voordat een nieuwe index was geplaatst
// hierdoor kon het model type (bijv Malibu) niet gevonden worden.
// TO DO: Bij het updaten van een Vehicle is de positie van newVehicle nu hetzelfde als de positie van oldVehicle (yay!), 
// echter moet ik nog zorgen dat het keuze menu uitgebreider gaat worden (niet alleen zoeken bij model?).
// Nu is nog steeds het eerste model dat gevonden wordt de gene die geupdate/ delete gaat worden. 
// TO DO: Code nalopen op "dead code".

public class Application {

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
          String vehicleModelInput = input.next();
          //updatedVehicleModel is nu updateResponseIndex en een int ipv een boolean
          int updateResponseIndex = vehicleService.updateVehicleModel(vehicleModelInput);
          // ipv updatedVehicleModel te checken op null checken of updateResponseIndex hoger dan 0 is (false is nu -1)
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
              Vehicle oldVehicle = vehicleService.searchByModel(vehicleModelInput);
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