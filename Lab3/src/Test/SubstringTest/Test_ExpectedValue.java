package Test.SubstringTest;

import com.company.Substring.DifferentLettersException;
import com.company.Substring.Substring;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Test_ExpectedValue {
    @Test
    public void testProperSolution(){
        String str1 = "abcd";
        String str2 = "bcda";

        try{
            int expectedValue = 2;
            int realValue = new Substring().substring(str1, str2);
            Assertions.assertEquals(expectedValue, realValue);
        } catch (DifferentLettersException e){
            System.out.println(e.getMessage());
        }
    }
}
