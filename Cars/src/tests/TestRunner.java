package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**  
* Taylor Layton - tglayton
* CIS175
* Sep 2, 2023
* Windows 10 
*/

public class TestRunner {
    public static void main(String[] args) {
        // Run the TestCar clas
        Result result = JUnitCore.runClasses(TestCar.class);
        
        // Prints out failures
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        // Print out if test is successful
        System.out.println(result.wasSuccessful());
    }
}