/*
 * CodecheckTest.java
 *
 * Junit tests for CodecheckCube.java and CodecheckSquare.java.
 *
 * @author David C. Petty // http://j.mp/psb_david_petty
 */
//ID Codecheck

import org.junit.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CodecheckTest {

    private static int[][] squares, cubes;

    @Before
    public void setUp() {
        // powers of two and their squares
        squares = new int[][] {
            {
                0, 0,
            },
            {
                1, 1,
            },
            {
                2, 4,
            },
            {
                4, 16,
            },
            {
                8, 64,
            },
            {
                16, 256,
            },
            {
                32, 1024,
            },
            {
                64, 4096,
            },
            {
                128, 16384,
            },
            {
                256, 65536,
            },
            {
                512, 262144,
            },
            {
                1024, 1048576,
            },
            {
                2048, 4194304,
            },
            {
                4096, 16777216,
            },
            {
                8192, 67108864,
            },
            {
                16384, 268435456,
            },
            {
                32768, 1073741824,
            },
        };

        // powers of two and their cubes
        cubes = new int[][] {
            {
                0, 0,
            },
            {
                1, 1,
            },
            {
                2, 8,
            },
            {
                4, 64,
            },
            {
                8, 512,
            },
            {
                16, 4096,
            },
            {
                32, 32768,
            },
            {
                64, 262144,
            },
            {
                128, 2097152,
            },
            {
                256, 16777216,
            },
            {
                512, 134217728,
            },
            {
                1024, 1073741824,
            },
        };
    }

    @After
    public void tearDown() {
        squares = null; cubes = null;
    }

    @Test
    public void testSquares() {
        System.out.printf("%s\n", Feedback.formatBanner("testSquares"));
        for (int i = 0; i < squares.length; i++) {
            int n = squares[i][0], nSquared = squares[i][1];
            System.out.printf("square(%s) \u2192 %s\n",
                n, CodecheckSquare.square(n));
            Assert.assertEquals(String.format("square(%s)", n),
                 nSquared, CodecheckSquare.square(n));
            }
    }

    @Test
    public void testCubes() {
        System.out.printf("%s\n", Feedback.formatBanner("testCubes"));
        for (int i = 0; i < cubes.length; i++) {
            int n = cubes[i][0], nCubed = cubes[i][1];
            System.out.printf("cube(%s) \u2192 %s\n",
                n, CodecheckCube.cube(n));
            Assert.assertEquals(String.format("cube(%s)", n),
                nCubed, CodecheckCube.cube(n));
            }
    }
}