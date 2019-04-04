package Test.SubstringTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        Should_ThrowException_If_DifferentLettersUsed.class,
        Should_ThrowException_If_EmptyString.class,
        Test_ExpectedValue.class,
        Test_CompareTwoStrings.class
})

public class SubstringTestSuite {
}
