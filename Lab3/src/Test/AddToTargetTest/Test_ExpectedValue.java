package Test.AddToTargetTest;

import com.company.AddToTarget.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class Test_ExpectedValue {
    @Test
    public void testProperSolution(){

        try{
            float[] arr = {1.0f, 2.0f, 3.0f};
            float target = 5.0f;
            int[] expectedResult = {1,2};
            int[] actualResult = new Solution().solution(arr, target);
        }catch (NoSolutionException e){
            System.out.println(e.getMessage());
        }
    }
}
