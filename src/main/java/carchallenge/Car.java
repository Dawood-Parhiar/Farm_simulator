package carchallenge;

public class Car extends Vehicle{

    private String model;
    private int doors;
    private int seats;

    public Car(String regNo, String engineCapacity, String transmission, String make, String colour, int year, int mileage, double price, String model, int doors, int seats) {
        super(regNo, engineCapacity, transmission, make, colour, year, mileage, price);
        this.model = model;
        this.doors = doors;
        this.seats = seats;
    }
}
