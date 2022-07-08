package main.java.com.devoteam.VehicleApplication;

import main.java.com.devoteam.VehicleApplication.service.VehicleApplicationLogic;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VehicleApplication {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Logger logger = Logger.getLogger(VehicleApplication.class.getName());
        boolean looping = true;
        VehicleApplicationLogic vehicleApplicationLogic = new VehicleApplicationLogic();

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
                case 1 -> vehicleApplicationLogic.switch1Logic();
                case 2 -> vehicleApplicationLogic.switch2Logic();
                case 3 -> vehicleApplicationLogic.switch3Logic();
                case 4 -> vehicleApplicationLogic.switch4Logic();
                case 5 -> vehicleApplicationLogic.switch5Logic();
                case 6 -> vehicleApplicationLogic.switch6Logic();
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
                    logger.log(Level.INFO, "Please pick a valid option");
                }

            }

        }

    }

}