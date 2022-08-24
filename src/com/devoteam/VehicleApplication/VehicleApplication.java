package com.devoteam.VehicleApplication;

import com.devoteam.VehicleApplication.service.ApplicationService;
import lombok.extern.log4j.Log4j2;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@Log4j2
public class VehicleApplication {

    public static void main(String[] args) {

        Scanner inputForSwitchMenu = new Scanner(System.in);
        Logger logger = Logger.getLogger(VehicleApplication.class.getName());
        boolean looping = true;
        ApplicationService applicationService = new ApplicationService();

        while (looping) {

            applicationService.menuLogic();
            int automakerMenuChoice = inputForSwitchMenu.nextInt();

            switch (automakerMenuChoice) {
                case 1 -> applicationService.switch1Logic();
                case 2 -> applicationService.switch2Logic();
                case 3 -> applicationService.switch3Logic();
                case 4 -> applicationService.switch4Logic();
                case 5 -> applicationService.switch5Logic();
                case 6 -> applicationService.switch6Logic();
                case 7 -> applicationService.switch7Logic();
                case 8 -> applicationService.switch8Logic();
                case 0 -> {
                    return;
                }
                default -> log.info("Please, select on of the above options");
            }

            boolean gettingAnswerFromUser = true;
            while (gettingAnswerFromUser) {
                Scanner inputForChooseToContinueMenu = new Scanner(System.in);

                log.info("\nDo you wish to continue? \n");
                log.info("1. Yes");
                log.info("2. No");

                int chooseToContinue = inputForChooseToContinueMenu.nextInt();
                boolean continuingApplication = chooseToContinue == 1;
                boolean quittingApplication = chooseToContinue == 2;

                if (continuingApplication) {
                    gettingAnswerFromUser = false;
                } else if (quittingApplication) {
                    gettingAnswerFromUser = false;
                    looping = false;
                } else {
                    logger.log(Level.WARNING, "Please pick a valid option");
                }
            }
        }
    }
}