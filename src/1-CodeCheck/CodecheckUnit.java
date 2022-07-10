/*
 * CodecheckUnit.java
 *
 * Run Junit tests for CodecheckCube.java and CodecheckSquare.java.
 *
 * @author David C. Petty // http://j.mp/psb_david_petty
 */

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class CodecheckUnit {
    public static void main(String[] args) {
        // Run JUnit tests.
        Class test = CodecheckTest.class;
        Result result = JUnitCore.runClasses(test);
        for (Failure failure : result.getFailures()) {
            System.out.printf("FAILURE: %s %s\n",
                failure.getTestHeader(), failure.getException());
        }
        System.out.printf("%s: %s test(s), %s failure(s), %s.\n", test.getName(),
            result.getRunCount(), result.getFailureCount(),
            result.wasSuccessful() ? "PASSED" : "DID NOT PASS");
    }
}