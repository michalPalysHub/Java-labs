package Test.SolutionTest;

import com.company.Solution.SizeOutOfRangeException;
import com.company.Solution.Solution;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Should_ThrowException_When_ListIsEmpty {

    @Test
    public void testIllegalArgumentException(){
        List<Integer> list = new ArrayList<>();

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Solution().solution(list);
        });
    }
}