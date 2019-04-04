package Test.AddToTargetTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class AddToTargetTestRunner {
    public static void main(String[] argv){
        Result result = JUnitCore.runClasses(AddToTargerTestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
