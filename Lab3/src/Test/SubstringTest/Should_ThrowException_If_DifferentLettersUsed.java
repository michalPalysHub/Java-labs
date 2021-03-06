package Test.SubstringTest;

import org.junit.Test;
import com.company.Substring.*;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Should_ThrowException_If_DifferentLettersUsed {

    @Test
    public void testCheckLettersUsedInString() {

        String string = "abc";
        String string2 = "abcd";

        DifferentLettersException thrown = assertThrows(DifferentLettersException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new Substring().substring(string, string2);
            }
        });
    }
}