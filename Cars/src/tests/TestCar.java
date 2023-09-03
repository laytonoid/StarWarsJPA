package tests;
import static org.junit.jupiter.api.Assertions.*;
import model.Car;
import model.CarDealer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**  
* Taylor Layton - tglayton
* CIS175
* Sep 2, 2023
* Windows 10 
*/

public class TestCar {
    CarDealer carDealerLogic = new CarDealer();
    Car car = new Car("Honda");

    @BeforeEach
    public void setUp() throws Exception {
        car.setPrice(20000);
        car.setYear(2020);
    }
    // Car make, price, year tests
    @Test
    public void testCarMake() {
        assertEquals("Honda", car.getMake());
    }
    @Test
    public void testCarPrice() {
        assertEquals(20000, car.getPrice());
    }
    @Test
    public void testCarYear() {
        assertEquals(2020, car.getYear());
    }

    // Logic tests
    @Test
    public void testCalculatePriceAfterTax() {
        double priceAfterTax = carDealerLogic.calculatePriceAfterTax(car);
        assertEquals(22000, priceAfterTax, 0.0);
    }
    @Test
    public void testIsVintage() {
        assertFalse(carDealerLogic.isVintageCar(car));
    }
}