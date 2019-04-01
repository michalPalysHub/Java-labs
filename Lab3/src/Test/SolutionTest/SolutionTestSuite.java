package Test.SolutionTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        Test_ExpectedValue.class,
        Should_ThrowException_When_ListElementIsTooBig.class,
        Should_ThrowException_When_ListHasTooManyElements.class,
        Should_ThrowException_When_ListIsEmpty.class
})

public class SolutionTestSuite {
}