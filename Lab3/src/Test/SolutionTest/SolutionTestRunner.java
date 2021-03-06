package Test.SolutionTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class SolutionTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SolutionTestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}

//w 5tym można sprawdzać, czy faktycznie czas optymistyczny jest szybszy niż realistyczny, czy tablice są wgl posortowane