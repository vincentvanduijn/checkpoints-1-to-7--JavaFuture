// --------15-6-2022------------
// Updated: Added last 2 points of checkpoint 3, checkpoint 3 is done
// Updated: In vehicleService at "duplicate entry code" added the .equals for vehicleType
// Updated: Deleted old imports
// BUGFIX: "old vehicle" no longer returns a "null" value
// BUGFIX: vehicleIndex deleted the input before opening the index space for a new entry, now it is replaced
// TO DO: When updating the Vehicle, newVehicle now replaces oldVehicle, 
// still need to implement the switch/ if-statement that makes sure the application doesn't take the first model on delete (see picture phone)
// TO DO: Change structure of the folders for the Java checkpoints (with Jens)

// --------21-6-2022------------
// Updated: Checkpoint 4 uploaded (V1), SolarLint added + configured as an extension to IntelliJ + Add the out file to .gitignore
// Updated:
// TO DO: When updating the Vehicle, newVehicle now replaces oldVehicle,
// still need to implement the switch/ if-statement that makes sure the application doesn't take the first model on delete (see picture phone).
// TO DO: Checkpoint 4 rework (see comments Jens, V2) + push on GIT
// TO DO: Make a checkpoint 4 Branch on GitHub, rework structure acording to files from Jens
// TO DO: Add a class to domain to house the format logic of the creatAt attribute + change the code for the randomizer +'
// change the constructors of the CAR and VEHICLE to no longer add creatAt + separate class for "date utility" from repository

// --------22-6-2022------------
// TO DO: Start from scratch, make DateTimer class + Randomizer class + delete methods for filter + go over the SolarLint comments + comments from Jens

// --------23-6-2022------------
// Updated: Start from scratch, make DateTimer class + Randomizer class + delete methods for filter + go over the SolarLint comments + comments from Jens
// TO DO: Bug where option 6 first runs correctly, but on the next run places the overview behind the menu "do you wish to continue"
// TO DO: When looking at checkpoint 5, make sure to add the "Streams" to update and delete vehicle
// This will make sure the program picks the correct index place from the chosen model by the user
// TO DO: Methods should not be longer then 25 lines

// --------6-7-2022------------
// Updated: Started with checkpoint 5, point 1,2,3,4 and 7 are done
// Updated: Only use the logger for faulty feedback statements (errors etc.). Otherwise use sout
// Updated: Methods should not be longer then 25 lines + make sure the variables used are self explanatory
// Updated: Make sure the Automaker ID stays the samen with new and updated Vehicles
// Updated: Bug where option 6 first runs correctly, but on the next run places the overview behind the menu "do you wish to continue"
// TO DO: When looking at checkpoint 5, make sure to add the "Streams" to update and delete vehicle
// This will make sure the program picks the correct index place from the chosen model by the user

// --------7-7-2022------------
// Updated: Checkpoint 5 point 1,2,3,4,5,6 and 7 are done
// Updated: Make all search function methods into Streams
// TO DO: Change update Vehicle to update instead of create/ delete, check for the correct index and start using streams
// TO DO: Add a VerhicleServiceHelper class and put the info in the switches in methods and call them from the class
// TO DO: If ALL for each loops should be (can be?) replaced instead of just the searchByAutomaker and searchByModel methods as stated in checkpoint 5. 
// TO DO: Delete Vehicle now prints all Vehicles, needs a fix + update vehicle doesn't recognize the Model that is inputted (this has to do with the streams search functions)

// --------8-7-2022------------
// Bugfix: Delete Vehicle now prints all Vehicles, needs a fix + update vehicle doesn't recognize the Model that is inputted (this has to do with the streams search functions)
// Updated: Add a VerhicleServiceHelper class and put the info in the switches in methods and call them from the class
// TO DO: Change update Vehicle to update instead of create/ delete, check for the correct index and start using streams
// TO DO: If ALL for each loops should be (can be?) replaced instead of just the searchByAutomaker and searchByModel methods as stated in checkpoint 5. 

// --------11-7-2022------------
// Updated: Added the DRAWIO file for checkpoint 6 in the Checkpoint folder, open on app.diagrams.net

//---------12-7-2022-------------
// TO DO: Update the Java files to make sure the "update" method now updates all vehicles with the same model name
// TO DO: Look at the Java comments and change them 
// TO DO: Normal forms in Database, naming column name on Database (Pascal case, camel case, snake case, kebab case). _between words + no uppercase letters

//---------14-7-2022-------------
// Updated: Changed checkpoint 6 to use the correct camel case. Added _between words + no uppercase letters
// Updated: Added toString options to the first and second switch logic to remove the List display of [ and ] and , and added the trim() function
// Updated: Made the continue menu into a boolean (talk with Ayush and Jens why this doesn't improve the code)
// Updated: Update vehicle model now replaces all values of the inputed model name + no longer replaces the position in the List (true update instead of a delete and replace)
// Updated: Delete now uses a forEach to delete (remove) the vehicles, same code for the update method
