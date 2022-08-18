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

//---------2-8-2022-------------
// TO DO: Get docker and mySQL connected to the java checkpoints folder

//---------5-8-2022-------------
// Updated: Changed the code in the Automaker and Vehicle class to use Lombok, and deleted all getters/setters/hashcode etc..

//---------8-8-2022-------------
// To Do: refactor points 2 to 4 from checkpoint 7
// Updated: Added the Log4j2 instead of the system out prints

//---------9-8-2022-------------
// To Do: Refactor the "while" statement that creates Vehicle objects into a method. Then call on that method from the "Find by" methods. 
// To Do: Refactor the "formatted object" statement that replaces and trims the output. Then call on that method in all the switch logic options.
// To Do: Make sure the output in switch option 2 and 6 display the Automaker name or id. 
// To Do: Add allias for the switch 1 (vehicle = v.name etc.)
// To Do: Search function save in index for Java (look up)
// To Do: Find out how to make sure the database doesn't lock on a search query 
// Updated: Add the created on variable to all classes, make sure the toString is formatted so the output is clearly readable
// Updated: Removed Date creation classes
// Updated: Refactor points 2 to 4 from checkpoint 7
// Updated: Make sure the "search by model" logic only displays vehicles that are identical to the search input. 

//---------10-8-2022-------------
// To Do: Make sure to catch exceptions when invalid input is given by the user
// To Do: Refactor the "while" statement that creates Vehicle objects into a method. Then call on that method from the "Find by" methods. 
// To Do: Refactor the "formatted object" statement that replaces and trims the output. Then call on that method in all the switch logic options.
// To Do: Make sure the output in switch option 2 and 6 display the Automaker name or id. 
// To Do: Search function save in index for Java (look up)
// To Do: Find out how to make sure the database doesn't lock on a search query
// To Do: Is the VehicleService class still needed because of the reduced size and logic? Ask Jens if it can be combined with VehicleApplicationLogic class and call directly from the Repository
// Updated: Working delete function for vehicle model
// Updated: Add allias for the switch 1 (vehicle = v.name etc.)
// Updated: Make sure the remove/delete function issues an error when there is no matching vehicle with the user input

//---------11-8-2022-------------
// To Do: Make sure to catch exceptions when invalid input is given by the user
// To Do: Refactor the "while" statement that creates Vehicle objects into a method. Then call on that method from the "Find by" methods. 
// To Do: Make sure the output in switch option 2 and 6 display the Automaker name or id. 
// To Do: Search function save in index for Java (look up)
// To Do: Find out how to make sure the database doesn't lock on a search query
// To Do: Is the VehicleService class still needed because of the reduced size and logic? Ask Jens if it can be combined with VehicleApplicationLogic class and call directly from the Repository
// Updated: Refactor the "formatted object" statement that replaces and trims the output. Then call on that method in all the switch logic options.

//---------12-8-2022------------
// To Do: Make sure to catch exceptions when invalid input is given by the user
// To Do: Make sure the output in switch option 2 and 6 display the Automaker name or id. 
// To Do: Search function save in index for Java (look up)
// To Do: Find out how to make sure the database doesn't lock on a search query
// To Do: When the checkpoint is working and finished, delete menu options 7 and 8. They are just to check if the methodes from AutomakerService/Repository work. 
// Updated: Combined the VehicleService class, AutomakerService class and the VehicleApplicationLogic class into ApplicationService class 
// Updated: Refactor the "while" statement that creates Vehicle objects into a method. Then call on that method from the "Find by" methods.

//---------15-8-2022------------
// To Do: Make sure to catch exceptions when invalid input is given by the user
// To Do: Make sure the output in switch option 2 and 6 display the Automaker name or id. 
// To Do: Search function save in index for Java (look up)
// To Do: Find out how to make sure the database doesn't lock on a search query
// To Do: When the checkpoint is working and finished, delete menu options 7 and 8. They are just to check if the methodes from AutomakerService/Repository work. 
// To Do: Make updated_on column, for the update (DateTime mySQL -> unix timestamp Java). Make the created_on for save (LocalDateTime) 

//---------16-8-2022------------
// To Do: Make sure the update does not duplicate al model types, make sure the Vehicle object gets the right Automaker_Id when updating
// To Do: Make sure to catch exceptions when invalid input is given by the user
// To Do: Make sure the output in switch option 2 and 6 display the Automaker name or id. 
// To Do: Search function save in index for Java (look up)
// To Do: Find out how to make sure the database doesn't lock on a search query
// To Do: When the checkpoint is working and finished, delete menu options 7 and 8. They are just to check if the methodes from AutomakerService/Repository work. 
// To Do: Make updated_on column, for the update (DateTime mySQL -> unix timestamp Java). Make the created_on for save (LocalDateTime)

//---------18-8-2022------------
// To Do: Make sure to catch exceptions when invalid input is given by the user
// To Do: Make sure the output in switch option 2 and 6 display the Automaker name or id. 
// To Do: Search function save in index for Java (look up)
// To Do: Find out how to make sure the database doesn't lock on a search query
// To Do: When the checkpoint is working and finished, delete menu options 7 and 8. They are just to check if the methodes from AutomakerService/Repository work. 
// To Do: Make updated_on column, for the update (DateTime mySQL -> unix timestamp Java). Make the created_on for save (LocalDateTime)
// Updated: All options from checkpoint 7 now work
// Updated: Make sure the update does not duplicate al model types, make sure the Vehicle object gets the right Automaker_Id when updating