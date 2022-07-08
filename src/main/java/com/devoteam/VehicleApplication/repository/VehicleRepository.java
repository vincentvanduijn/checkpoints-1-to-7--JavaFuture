package main.java.com.devoteam.VehicleApplication.repository;

import main.java.com.devoteam.VehicleApplication.domain.Automaker;
import main.java.com.devoteam.VehicleApplication.domain.Car;
import main.java.com.devoteam.VehicleApplication.domain.Vehicle;
import main.java.com.devoteam.VehicleApplication.domain.VehicleTypeEnum;

import java.util.ArrayList;
import java.util.List;


public class VehicleRepository {
    List<Vehicle> vehicleArray = new ArrayList<>();
    AutomakerRepository automakerRepository;

    public VehicleRepository(AutomakerRepository automakerRepository) {
        this.automakerRepository = automakerRepository;
        this.createVehicles();
    }

    public List<Vehicle> getVehicleArray() {
        return this.vehicleArray;
    }

    public void setVehicleArray(List<Vehicle> vehicleArray) {
        this.vehicleArray = vehicleArray;
    }


    private void createVehicles() {

        Automaker automaker1 = new Automaker("GM");
        Automaker automaker2 = new Automaker("Hyundai");
        Automaker automaker3 = new Automaker("Volkswagen");
        Automaker automaker4 = new Automaker("Audi");
        Automaker automaker5 = new Automaker("Mercedes");
        Automaker automaker6 = new Automaker("Peugeot");

        automakerRepository.addToAutomakerArray(automaker1);
        automakerRepository.addToAutomakerArray(automaker2);
        automakerRepository.addToAutomakerArray(automaker3);
        automakerRepository.addToAutomakerArray(automaker4);
        automakerRepository.addToAutomakerArray(automaker5);
        automakerRepository.addToAutomakerArray(automaker6);

        // GM
        Vehicle vehicle01 = new Car(automaker1, "Suburban", "Red", 2000, VehicleTypeEnum.CAR,DateRandomizer.randomiseCreatedAt() );
        Vehicle vehicle02 = new Car(automaker1, "Malibu", "Red", 2000, VehicleTypeEnum.CAR, DateRandomizer.randomiseCreatedAt() );
        Vehicle vehicle03 = new Car(automaker1, "Silverado", "Red", 2000, VehicleTypeEnum.CAR,DateRandomizer.randomiseCreatedAt() );

        // Hyundai
        Vehicle vehicle11 = new Car(automaker2, "Azera", "Red", 2000, VehicleTypeEnum.CAR,DateRandomizer.randomiseCreatedAt() );
        Vehicle vehicle12 = new Car(automaker2, "Sonata", "Red", 2000, VehicleTypeEnum.CAR,DateRandomizer.randomiseCreatedAt() );
        Vehicle vehicle13 = new Car(automaker2, "Veloster", "Red", 2000, VehicleTypeEnum.CAR,DateRandomizer.randomiseCreatedAt() );

        // Volkswagen
        Vehicle vehicle21 = new Car(automaker3, "Golf", "Red", 2000, VehicleTypeEnum.CAR,DateRandomizer.randomiseCreatedAt() );
        Vehicle vehicle22 = new Car(automaker3, "Jetta", "Red", 2000, VehicleTypeEnum.CAR,DateRandomizer.randomiseCreatedAt() );
        Vehicle vehicle23 = new Car(automaker3, "Polo", "Red", 2000, VehicleTypeEnum.CAR,DateRandomizer.randomiseCreatedAt() );

        // Audi
        Vehicle vehicle31 = new Car(automaker4, "A4", "Red", 2000, VehicleTypeEnum.CAR,DateRandomizer.randomiseCreatedAt() );
        Vehicle vehicle32 = new Car(automaker4, "Q7", "Red", 2000, VehicleTypeEnum.CAR,DateRandomizer.randomiseCreatedAt() );
        Vehicle vehicle33 = new Car(automaker4, "R8", "Red", 2000, VehicleTypeEnum.CAR, DateRandomizer.randomiseCreatedAt() );

        // Mercedes
        Vehicle vehicle41 = new Car(automaker5, "C180", "Red", 2000, VehicleTypeEnum.CAR,DateRandomizer.randomiseCreatedAt() );
        Vehicle vehicle42 = new Car(automaker5, "C200", "Red", 2000, VehicleTypeEnum.CAR,DateRandomizer.randomiseCreatedAt() );
        Vehicle vehicle43 = new Car(automaker5, "GLA200", "Red", 2000, VehicleTypeEnum.CAR,DateRandomizer.randomiseCreatedAt() );

        // Peugeot
        Vehicle vehicle51 = new Car(automaker6, "206", "Red", 2000, VehicleTypeEnum.CAR,DateRandomizer.randomiseCreatedAt() );
        Vehicle vehicle52 = new Car(automaker6, "208", "Red", 2000, VehicleTypeEnum.CAR,DateRandomizer.randomiseCreatedAt() );
        Vehicle vehicle53 = new Car(automaker6, "2008", "Red", 2000, VehicleTypeEnum.CAR,DateRandomizer.randomiseCreatedAt() );

        vehicleArray.add(vehicle01);
        vehicleArray.add(vehicle02);
        vehicleArray.add(vehicle03);
        vehicleArray.add(vehicle11);
        vehicleArray.add(vehicle12);
        vehicleArray.add(vehicle13);
        vehicleArray.add(vehicle21);
        vehicleArray.add(vehicle22);
        vehicleArray.add(vehicle23);
        vehicleArray.add(vehicle31);
        vehicleArray.add(vehicle32);
        vehicleArray.add(vehicle33);
        vehicleArray.add(vehicle41);
        vehicleArray.add(vehicle42);
        vehicleArray.add(vehicle43);
        vehicleArray.add(vehicle51);
        vehicleArray.add(vehicle52);
        vehicleArray.add(vehicle53);

    }

}
