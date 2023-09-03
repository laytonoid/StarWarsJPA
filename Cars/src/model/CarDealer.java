package model;

/**  
* Taylor Layton - tglayton
* CIS175
* Sep 2, 2023
* Windows 10 
*/

public class CarDealer {

    public boolean isVintageCar(Car car) {
        return car.getYear() < 1990;
    }
    
    public double calculatePriceAfterTax(Car car) {
        return car.getPrice() * 1.1; // Assuming a 10% tax
    }
}