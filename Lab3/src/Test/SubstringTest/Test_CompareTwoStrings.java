package Test.SubstringTest;

import com.company.Substring.*;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Test_CompareTwoStrings {
    @Test
    public void testTwoStringsComparison(){
        boolean[] string = new Substring().checkLettersUsedInString("string");
        boolean[] string2 = new Substring().checkLettersUsedInString("string");

        assertArrayEquals(string, string2);
    }
}
