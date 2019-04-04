package Test.SolutionTest;

import com.company.Solution.ElementOutOfRangeException;
import com.company.Solution.Solution;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Should_ThrowException_When_ListElementIsTooBig {

    @Test
    public void testElementOutOfRangeException(){
        List<Integer> list = new ArrayList<>();
        list.add(10000000);

        ElementOutOfRangeException thrown = assertThrows(ElementOutOfRangeException.class, () -> {
          new Solution().solution(list);
        });
    }
}