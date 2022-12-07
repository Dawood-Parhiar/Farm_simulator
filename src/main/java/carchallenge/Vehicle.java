package carchallenge;

public class Vehicle {

    private String regNo;
    private String engineCapacity;
    private String transmission;
    private String make;
    private String colour;
    private int year;
    private int mileage;

    public Vehicle(String regNo, String engineCapacity, String transmission, String make, String colour, int year, int mileage,double price) {
        this.regNo = regNo;
        this.engineCapacity = engineCapacity;
        this.transmission = transmission;
        this.make = make;
        this.colour = colour;
        this.year = year;
        this.mileage = mileage;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getMake() {
        return make;
    }

    public String getColour() {
        return colour;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }
}
