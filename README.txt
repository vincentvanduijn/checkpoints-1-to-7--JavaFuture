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

