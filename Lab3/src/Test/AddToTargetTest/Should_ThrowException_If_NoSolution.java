package Test.AddToTargetTest;

import com.company.AddToTarget.NoSolutionException;
import com.company.AddToTarget.Solution;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Should_ThrowException_If_NoSolution {

    @Test
    public void testIfNoSolution(){
        float[] arr = {1.0f, 2.0f, 3.0f};
        float target = 6.0f;

        NoSolutionException thrown = assertThrows(NoSolutionException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new Solution().solution(arr, target);
            }
        });
    }
}
