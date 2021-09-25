package models;
//import lombok.*;

public class Car {

    String address;
    String make;
    String model;
    String year;
    String engine;
    String fuel;
    String gear;
    String wD;
    String doors;
    String seats;
    String clasS;
    String fuelConsumption;
    String carRegNumber;
    String price;
    String distanceIncluded;
    String typeFeature;
    String about;

    public Car withAddress(String address) {
        this.address = address;
        return this;
    }

    public Car withMake(String make) {
        this.make = make;
        return this;
    }

    public Car withModel(String model) {
        this.model = model;
        return this;
    }

    public Car withYear(String year) {
        this.year = year;
        return this;
    }

    public Car withEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public Car withFuel(String fuel) {
        this.fuel = fuel;
        return this;
    }

    public Car withGear(String gear) {
        this.gear = gear;
        return this;
    }

    public Car withWD(String wD) {
        this.wD = wD;
        return this;
    }

    public Car withDoors(String doors) {
        this.doors = doors;
        return this;
    }

    public Car withSeats(String seats) {
        this.seats = seats;
        return this;
    }

    public Car withClasS(String clasS) {
        this.clasS = clasS;
        return this;
    }

    public Car withFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public Car withCarRegNumber(String carRegNumber) {
        this.carRegNumber = carRegNumber;
        return this;
    }

    public Car withPrice(String price) {
        this.price = price;
        return this;
    }

    public Car withDistanceIncluded(String distanceIncluded) {
        this.distanceIncluded = distanceIncluded;
        return this;
    }

    public Car withTypeFeature(String typeFeature) {
        this.typeFeature = typeFeature;
        return this;
    }

    public Car withAbout(String about) {
        this.about = about;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getEngine() {
        return engine;
    }

    public String getFuel() {
        return fuel;
    }

    public String getGear() {
        return gear;
    }

    public String getWD() {
        return wD;
    }

    public String getDoors() {
        return doors;
    }

    public String getSeats() {
        return seats;
    }

    public String getClasS() {
        return clasS;
    }

    public String getFuelConsumption() {
        return fuelConsumption;
    }

    public String getCarRegNumber() {
        return carRegNumber;
    }

    public String getPrice() {
        return price;
    }

    public String getDistanceIncluded() {
        return distanceIncluded;
    }

    public String getTypeFeature() {
        return typeFeature;
    }

    public String getAbout() {
        return about;
    }

    @Override
    public String toString() {
        return "Car{" +
                "address='" + address + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", Year='" + year + '\'' +
                ", engine='" + engine + '\'' +
                ", fuel='" + fuel + '\'' +
                ", gear='" + gear + '\'' +
                ", wD='" + wD + '\'' +
                ", doors='" + doors + '\'' +
                ", seats='" + seats + '\'' +
                ", clasS='" + clasS + '\'' +
                ", fuelConsumption='" + fuelConsumption + '\'' +
                ", carRegNumber='" + carRegNumber + '\'' +
                ", price='" + price + '\'' +
                ", distanceIncluded='" + distanceIncluded + '\'' +
                ", typeFeature='" + typeFeature + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
