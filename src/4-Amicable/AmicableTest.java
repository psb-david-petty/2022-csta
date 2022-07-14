/*
 * AmicableTest.java
 *
 * Junit tests for Amicable.java
 *
 * @author David C. Petty // http://j.mp/psb_david_petty
 */

import org.junit.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AmicableTest {

    private static int[] sums = {
        0, 0, 1, 1, 3, 1, 6, 1, 7, 4, 8, 1, 16, 1, 10, 9, 15, 1, 21, 1,
        22, 11, 14, 1, 36, 6, 16, 13, 28, 1, 42, 1, 31, 15, 20, 13, 55,
        1, 22, 17, 50, 1, 54, 1, 40, 33, 26, 1, 76, 8, 43, 21, 46, 1,
        66, 17, 64, 23, 32, 1, 108, 1, 34, 41, 63, 19, 78, 1, 58, 27,
        74, 1, 123, 1, 40, 49, 64, 19, 90, 1, 106, 40, 44, 1, 140, 23,
        46, 33, 92, 1, 144, 21, 76, 35, 50, 25, 156, 1, 73, 57, 117,
    };
    
    private static int[] minima = {
        6, 28, 220, 496, 1184, 2620, 5020, 6232, 8128, 10744, 12285,
        17296, 63020, 66928, 67095, 69615, 79750, 100485, 122265,
        122368, 141664, 142310, 171856, 176272, 10, 100, 1000, 10000,
        100000,
    };

    private static int[] maxima = {
        6, 28, 284, 496, 1210, 2924, 5564, 6368, 8128, 10856, 14595,
        18416, 76084, 66992, 71145, 87633, 88730, 124155, 139815,
        123152, 153176, 168730, 176336, 180848, 470, 4700, 47000,
        470000, 4700000,
    };

    private static boolean[] amicable = {
        true, true, true, true, true, true, true, true, true, true,
        true, true, true, true, true, true, true, true, true, true,
        true, true, true, true, false, false, false, false, false,
    };

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSumProperDivisors() {
        System.out.printf("%s\n", Feedback.formatBanner("testSumProperDivisors"));
//HIDE
        for (int i = 0; i < sums.length; i++) {
            System.out.printf("sumProperDivisors(%s) == %s\n",
                i, Amicable.sumProperDivisors(i));
            Assert.assertEquals(String.format("sumProperDivisors(%s)", i),
                 sums[i], Amicable.sumProperDivisors(i));
            //EDIT // Complete test of sumProperDivisors, giving feedback.
            }
    }

    @Test
    public void testAreAmicable() {
        System.out.printf("%s\n", Feedback.formatBanner("testAreAmicable"));
//HIDE
        assert minima.length == maxima.length && maxima.length == amicable.length:
            String.format("minima (%s), maxima (%s) or amicable (%s) not the same length\n",
                minima.length, maxima.length, amicable.length);
        for (int i = 0; i < minima.length; i++) {
            System.out.printf("areAmicable(%s, %s) == %s\n",
                minima[i], maxima[i], Amicable.areAmicable(minima[i], maxima[i]), amicable[i]);
            Assert.assertEquals("areAmicable(" + minima[i] + ", " + maxima[i] + ")",
                amicable[i], Amicable.areAmicable(minima[i], maxima[i]));
            //EDIT // Complete test of areAmicable, giving feedback.
        }
    }
}