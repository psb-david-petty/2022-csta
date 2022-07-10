/*
 * CodecheckTester.java
 *
 * Tests for CodecheckCube.java and CodecheckSquare.java.
 *
 * @author David C. Petty // http://j.mp/psb_david_petty
 */

public class CodecheckTester {

    // Powers of two up to square root of Integer.MAX_VALUE.
    private static int[] squares = {
        1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 
    };
    // Powers of two up to cube root of Integer.MAX_VALUE.
    private static int[] cubes = {
        1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 
    };

    public static void main(String [] args)
    {
        System.out.printf("%s\n", Feedback.formatBanner("CodecheckTester"));
 
        // Unit tests with "Expected: " output format.
        for (int i = 0; i < squares.length; i++) {
            System.out.printf("squares(%s): %s\n",
                squares[i], CodecheckSquare.square(squares[i]));
            System.out.printf("Expected: %s\n", squares[i] * squares[i]);
        }
        for (int i = 0; i < cubes.length; i++) {
            System.out.printf("cubes(%s): %s\n",
                cubes[i], CodecheckCube.cube(cubes[i]));
            System.out.printf("Expected: %s\n", cubes[i] * cubes[i] * cubes[i]);
        }
    }
}