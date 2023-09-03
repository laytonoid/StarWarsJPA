package model;

/**  
* Taylor Layton - tglayton
* CIS175
* Sep 2, 2023
* Windows 10 
*/

public class Car {
    private String make;
    private double price;
    private int year;

    public Car() {
    }

    public Car(String make) {
        this.make = make;
    }

    // Getters
    public String getMake() {
        return make;
    }
    public double getPrice() {
        return price;
    }
    public int getYear() {
        return year;
    }
    
    // Setters
    public void setMake(String make) {
        this.make = make;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", price=" + price +
                ", year=" + year +
                '}';
    }
}