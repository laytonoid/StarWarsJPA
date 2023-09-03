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
        // Run TestCar class
        Result result = JUnitCore.runClasses(TestCar.class);
        
        // Print out any failures
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        // Print out if all tests were successful
        System.out.println(result.wasSuccessful());
    }
}