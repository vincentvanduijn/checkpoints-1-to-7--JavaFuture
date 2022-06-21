package Devoteam.Checkpoints.checkpoint4.repository;

import Devoteam.Checkpoints.checkpoint4.domain.Automaker;
import Devoteam.Checkpoints.checkpoint4.domain.Car;
import Devoteam.Checkpoints.checkpoint4.domain.Vehicle;
import Devoteam.Checkpoints.checkpoint4.domain.VehicleTypeEnum;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class VehicleRepository {
    ArrayList<Vehicle> vehicleArray = new ArrayList<Vehicle>();

    public VehicleRepository() {
        this.createVehicles();
    }

    public ArrayList<Vehicle> getVehicleArray() {
        return this.vehicleArray;
    }

    public void setVehicleArray(ArrayList<Vehicle> vehicleArray) {
        this.vehicleArray = vehicleArray;
    }
//JENS: deze functie uit je repository halen een in een helper functie gooien? in ..main.java.nl.devoteam.futures.checkpoint4.util.randomizer.java
    public String randomiseCreatedAt() {
        long ms;
        Random rnd;
        rnd = new Random();
        //JENS: Er is ongetijfeld een handigere manier (https://www.baeldung.com/java-random-dates), maar als dit werkt is het cool
        //Een andere developer zou later nooit meer weten wat deze nummers betekenen
        ms = 946771200000L + (Math.abs(rnd.nextLong()) % (10L * 365 * 24 * 60 * 60 * 1000));
        return new Date(ms).toString();
    }

    private void createVehicles() {

        Automaker automaker1 = new Automaker("GM");
        Automaker automaker2 = new Automaker("Hyundai");
        Automaker automaker3 = new Automaker("Volkswagen");
        Automaker automaker4 = new Automaker("Audi");
        Automaker automaker5 = new Automaker("Mercedes");
        Automaker automaker6 = new Automaker("Peugot");

        // GM
        Vehicle vehicle01 = new Car(automaker1, "Suburban", "Red", 2000, VehicleTypeEnum.CAR, randomiseCreatedAt());
        Vehicle vehicle02 = new Car(automaker1, "Malibu", "Red", 2000, VehicleTypeEnum.CAR, randomiseCreatedAt());
        Vehicle vehicle03 = new Car(automaker1, "Silverado", "Red", 2000, VehicleTypeEnum.CAR, randomiseCreatedAt());

        // Hyundai
        Vehicle vehicle11 = new Car(automaker2, "Azera", "Red", 2000, VehicleTypeEnum.CAR, randomiseCreatedAt());
        Vehicle vehicle12 = new Car(automaker2, "Sonata", "Red", 2000, VehicleTypeEnum.CAR, randomiseCreatedAt());
        Vehicle vehicle13 = new Car(automaker2, "Veloster", "Red", 2000, VehicleTypeEnum.CAR, randomiseCreatedAt());

        // Volkswagen
        Vehicle vehicle21 = new Car(automaker3, "Golf", "Red", 2000, VehicleTypeEnum.CAR, randomiseCreatedAt());
        Vehicle vehicle22 = new Car(automaker3, "Jetta", "Red", 2000, VehicleTypeEnum.CAR, randomiseCreatedAt());
        Vehicle vehicle23 = new Car(automaker3, "Polo", "Red", 2000, VehicleTypeEnum.CAR, randomiseCreatedAt());

        // Audi
        Vehicle vehicle31 = new Car(automaker4, "A4", "Red", 2000, VehicleTypeEnum.CAR, randomiseCreatedAt());
        Vehicle vehicle32 = new Car(automaker4, "Q7", "Red", 2000, VehicleTypeEnum.CAR, randomiseCreatedAt());
        Vehicle vehicle33 = new Car(automaker4, "R8", "Red", 2000, VehicleTypeEnum.CAR, randomiseCreatedAt());

        // Mercedes
        Vehicle vehicle41 = new Car(automaker5, "C180", "Red", 2000, VehicleTypeEnum.CAR, randomiseCreatedAt());
        Vehicle vehicle42 = new Car(automaker5, "C200", "Red", 2000, VehicleTypeEnum.CAR, randomiseCreatedAt());
        Vehicle vehicle43 = new Car(automaker5, "GLA200", "Red", 2000, VehicleTypeEnum.CAR, randomiseCreatedAt());

        // Peugot
        Vehicle vehicle51 = new Car(automaker6, "206", "Red", 2000, VehicleTypeEnum.CAR, randomiseCreatedAt());
        Vehicle vehicle52 = new Car(automaker6, "208", "Red", 2000, VehicleTypeEnum.CAR, randomiseCreatedAt());
        Vehicle vehicle53 = new Car(automaker6, "2008", "Red", 2000, VehicleTypeEnum.CAR, randomiseCreatedAt());

        this.vehicleArray.add(vehicle01);
        this.vehicleArray.add(vehicle02);
        this.vehicleArray.add(vehicle03);
        this.vehicleArray.add(vehicle11);
        this.vehicleArray.add(vehicle12);
        this.vehicleArray.add(vehicle13);
        this.vehicleArray.add(vehicle21);
        this.vehicleArray.add(vehicle22);
        this.vehicleArray.add(vehicle23);
        this.vehicleArray.add(vehicle31);
        this.vehicleArray.add(vehicle32);
        this.vehicleArray.add(vehicle33);
        this.vehicleArray.add(vehicle41);
        this.vehicleArray.add(vehicle42);
        this.vehicleArray.add(vehicle43);
        this.vehicleArray.add(vehicle51);
        this.vehicleArray.add(vehicle52);
        this.vehicleArray.add(vehicle53);

    }

}
