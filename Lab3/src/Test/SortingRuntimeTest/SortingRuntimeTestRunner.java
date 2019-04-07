package Test.SortingRuntimeTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class SortingRuntimeTestRunner {
    public static void main(String argv[]){
        Result result = JUnitCore.runClasses(SortingRuntimeTestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
