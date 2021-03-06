package Test.SolutionTest;

import com.company.Solution.SizeOutOfRangeException;
import com.company.Solution.Solution;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Should_ThrowException_When_ListHasTooManyElements {

    @Test
    public void testElementOutOfRangeException(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(1);
        }

        SizeOutOfRangeException thrown = assertThrows(SizeOutOfRangeException.class, () -> {
            new Solution().solution(list);
        });
    }
}