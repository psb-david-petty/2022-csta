/*
 * SuccessorsTest.java
 *
 * Junit tests for Successors.java
 *
 * RED_FLAG: the canonical solution will not work for these ragged array tests
 *
 * @author David C. Petty // http://j.mp/psb_david_petty
 */

import org.junit.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class SuccessorsTest {

    private static int[][][] ias = {
        {
            {
                15, 5, 9, 10,
            },
            {
                12, 16, 11, 6,
            },
            {
                14, 8, 13, 7,
            },
        },
        {
            {
                47,
            },
            {
                48, 49,
            },
            {
                50, 51, 52,
            },
            {
                53, 54,
            },
            {
                55,
            },
        },
    };

    private static int[][] ras = {
        {
            5, 16,
        },
        {
            47, 55,
        },
    };

    private static Position[][] pas = {
        {
            new Position(1,3), new Position(2,3), new Position(2,1),
            new Position(0,2), new Position(0,3), new Position(1,2),
            new Position(1,0), new Position(2,2), new Position(2,0),
            new Position(0,0), new Position(1,1),
        },
        {
            new Position(1,0), new Position(1,1), new Position(2,0),
            new Position(2,1), new Position(2,2), new Position(3,0),
            new Position(3,1), new Position(4,0),
        },
    };

    private static Position[][][] sas = {
        {
            {
                null, new Position(2,3), new Position(1,2),
                new Position(1,0),
            },
            {
                new Position(2,0), null, new Position(2,2),
                new Position(2,1),
            },
            {
                new Position(1,1), new Position(0,3),
                new Position(0,0), new Position(0,2),
            },
        },
        {
            {
                new Position(1,1),
            },
            {
                new Position(2,0), new Position(2,1),
            },
            {
                new Position(2,2), new Position(3,0),
                new Position(3,1),
            },
            {
                new Position(4,0), null,
            },
            {
                null,
            },
        },
    };

    @Before
    public void setup() {
    }

    @After
    public void teardown() {
    }

    @Test
    public void testFindPosition() {
        System.out.printf("%s\n", Feedback.formatBanner("testFindPosition"));
        assert ias.length == ras.length && ras.length == pas.length
            : "ias.length != ras.length || ras.length != pas.length";
        for (int i = 0; i < ias.length; i++) {
//HIDE
            int start = ras[i][0], end = ras[i][1];
            for (int j = 0; j < pas[i].length; j++) {
                Position ap = Successors.findPosition(j + start, ias[i]);
                System.out.printf("%s[%s] = %s\n",
                    Arrays.deepToString(ias[i]), j + start, ap);
            Assert.assertEquals(pas[i][j].toString() + " != " + ap,
                pas[i][j], ap);
            //EDIT // Give feedback on findPosition and use method from Assert to test.
            }
        }
    }

    @Test
    public void testGetSuccessorArray() {
        System.out.printf("%s\n", Feedback.formatBanner("testSetSuccessorArray"));
        assert ias.length == sas.length : "ias.length != sas.length";
        for (int i = 0; i < ias.length; i++) {
//HIDE
            Position[][] aa = Successors.getSuccessorArray(ias[i]);
            Position[][] ea = sas[i];
            System.out.printf("%s -> %s\n",
                Feedback.format2Dint(ias[i]), Feedback.format2DObject(aa));
            Assert.assertArrayEquals(Arrays.deepToString(ea)
                + " != " + Arrays.deepToString(aa),
                aa, ea);
            //EDIT // Give feedback on getSuccessorArray and use method from Assert to test.
        }
    }
}