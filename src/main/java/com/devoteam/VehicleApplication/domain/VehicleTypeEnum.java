package com.devoteam.VehicleApplication.domain;

import java.util.Date;

public enum VehicleTypeEnum {
    CAR("CAR") {
        public Vehicle buildNewVehicle(int id, Date createdOn, Automaker automaker, String model, String color, int year) {
            return new Car(id, createdOn, automaker, model, color, year, CAR);
        }
    },
    MOTORCYCLE("MOTORCYCLE") {
        @Override
        public Vehicle buildNewVehicle(int id, Date createdOn, Automaker automaker, String model, String color, int year) {
            return new Motorcycle(id, createdOn, automaker, model, color, year, MOTORCYCLE);
        }
    },

    VAN("VAN") {
        @Override
        public Vehicle buildNewVehicle(int id, Date createdOn, Automaker automaker, String model, String color, int year) {
            return new Van(id, createdOn, automaker, model, color, year, VAN);
        }
    },

    TRUCK("TRUCK") {
        @Override
        public Vehicle buildNewVehicle(int id, Date createdOn, Automaker automaker, String model, String color, int year) {
            return new Truck(id, createdOn, automaker, model, color, year, TRUCK);
        }
    },

    PICKUP("PICKUP") {
        @Override
        public Vehicle buildNewVehicle(int id, Date createdOn, Automaker automaker, String model, String color, int year) {
            return new Pickup(id, createdOn, automaker, model, color, year, PICKUP);
        }
    },

    OTHERS("OTHERS") {
        @Override
        public Vehicle buildNewVehicle(int id, Date createdOn, Automaker automaker, String model, String color, int year) {
            return new Others(id, createdOn, automaker, model, color, year, OTHERS);
        }
    };

    public final String vehicleType;

    VehicleTypeEnum(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public abstract Vehicle buildNewVehicle(int id, Date createdOn, Automaker automaker, String model, String color, int year);

}
