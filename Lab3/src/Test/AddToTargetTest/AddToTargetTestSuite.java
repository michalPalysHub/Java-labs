package Test.AddToTargetTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        Test_ExpectedValue.class,
        Should_ThrowException_If_NoSolution.class,
        Should_ThrowException_If_EmptyArray.class
})

public class AddToTargetTestSuite {
}
