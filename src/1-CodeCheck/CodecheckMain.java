/*
 * CodecheckMain.java
 *
 * Tests for CodecheckCube.java and CodecheckSquare.java.
 *
 * @author David C. Petty // http://j.mp/psb_david_petty
 */

import java.util.*;

public class CodecheckMain {

    // Powers of two up to cube root of Integer.MAX_VALUE.
    private static int[] powers = {
        1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024,
    };

    // Print test results to System.out.
    public static void main(String [] args)
    {
        /*
         * Test using generated data or static data.
         */
        System.out.printf("%s\n", Feedback.formatBanner("CodecheckMain"));

        // Print square of integers on [0, 20].
        for (int n = 0; n <= 20; n++)
            System.out.printf("%s ", CodecheckSquare.square(n));
        System.out.printf("\n");
        // Print cube of powers.
        for (int n : powers)
            System.out.printf("%s ", CodecheckCube.cube(n));
        System.out.printf("\n");

        /*
         * Test using test.in data read through System.in.
         */
        Scanner in = new Scanner(System.in);
        // Print square for each of first data group.
        while (true)
        {
            System.out.print("Enter an integer > 1, 0 to quit: ");
            int n = in.nextInt();
            if (n == 0) break;
            System.out.printf("square(%s) = %s\n", n, CodecheckSquare.square(n));
        }
        System.out.printf("\n");

        // Print cube for each of second data group.
        while (true)
        {
            System.out.print("Enter an integer > 1, 0 to quit: ");
            int n = in.nextInt();
            if (n == 0) break;
            System.out.printf("cube(%s) = %s\n", n, CodecheckCube.cube(n));
        }
    }
}