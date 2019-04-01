package Test.SolutionTest;

import com.company.Solution.ElementOutOfRangeException;
import com.company.Solution.SizeOutOfRangeException;
import com.company.Solution.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest1 {

    @Test
    public void testProperSolution(){
        List<Integer> testList = new ArrayList<>();
        testList.add(-9);
        testList.add(9);
        testList.add(-3);
        testList.add(3);
        testList.add(-1);
        testList.add(1);
        testList.add(4);
        testList.add(-5);

        try {
            int expectedValue = 2;
            int solutionResult = new Solution().solution(testList);
            Assertions.assertEquals(expectedValue, solutionResult, 0);
        } catch (SizeOutOfRangeException e) {
            System.out.println(e.getMessage());
        } catch (ElementOutOfRangeException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
