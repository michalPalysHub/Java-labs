package Test.AddToTargetTest;

import com.company.AddToTarget.Solution;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Should_ThrowException_If_EmptyArray {

    @Test
    public void testIfNoSolution(){
        float[] arr = {};
        float target = 6.0f;

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new Solution().solution(arr, target);
            }
        });
    }
}
