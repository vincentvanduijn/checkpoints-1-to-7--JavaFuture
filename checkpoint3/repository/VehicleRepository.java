package Devoteam.Checkpoints.checkpoint3.repository;

import java.util.ArrayList;

import Devoteam.Checkpoints.checkpoint3.domain.Automaker;
import Devoteam.Checkpoints.checkpoint3.domain.Car;
import Devoteam.Checkpoints.checkpoint3.domain.Vehicle;


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

    private void createVehicles() {

        Automaker automaker1 = new Automaker("GM");
        Automaker automaker2 = new Automaker("Hyundai");
        Automaker automaker3 = new Automaker("Volkswagen");
        Automaker automaker4 = new Automaker("Audi");
        Automaker automaker5 = new Automaker("Mercedes");
        Automaker automaker6 = new Automaker("Peugot");

        // GM
        Vehicle vehicle01 = new Car(automaker1, "Suburban", "Red", 2000);
        Vehicle vehicle02 = new Car(automaker1, "Malibu", "Red", 2000);
        Vehicle vehicle03 = new Car(automaker1, "Silverado", "Red", 2000);

        // Hyundai
        Vehicle vehicle11 = new Car(automaker2, "Azera", "Red", 2000);
        Vehicle vehicle12 = new Car(automaker2, "Sonata", "Red", 2000);
        Vehicle vehicle13 = new Car(automaker2, "Veloster", "Red", 2000);

        // Volkswagen
        Vehicle vehicle21 = new Car(automaker3, "Golf", "Red", 2000);
        Vehicle vehicle22 = new Car(automaker3, "Jetta", "Red", 2000);
        Vehicle vehicle23 = new Car(automaker3, "Polo", "Red", 2000);

        // Audi
        Vehicle vehicle31 = new Car(automaker4, "A4", "Red", 2000);
        Vehicle vehicle32 = new Car(automaker4, "Q7", "Red", 2000);
        Vehicle vehicle33 = new Car(automaker4, "R8", "Red", 2000);

        // Mercedes
        Vehicle vehicle41 = new Car(automaker5, "C 180", "Red", 2000);
        Vehicle vehicle42 = new Car(automaker5, "C 200", "Red", 2000);
        Vehicle vehicle43 = new Car(automaker5, "GLA 200", "Red", 2000);

        // Peugot
        Vehicle vehicle51 = new Car(automaker6, "206", "Red", 2000);
        Vehicle vehicle52 = new Car(automaker6, "208", "Red", 2000);
        Vehicle vehicle53 = new Car(automaker6, "2008", "Red", 2000);

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
