/*
 * CircleTest.java
 *
 * Junit tests for Circle.java.
 *
 * @author David C. Petty // http://j.mp/psb_david_petty
 */
//ID Circle

import org.junit.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CircleTest {
    private static Circle[] circles = {
        new Circle(0.0,0.0,10.0), new Circle(100.0,100.0,100.0),
    };

    private static double[] areas = {
        314.1593, 31415.9265,
    };

    private static double[][] points = {
        {
            10.00099, 0.0,
        },
        {
            100.0, -0.0099,
        },
    };

    private static boolean[] isOns = {
        true, true,
    };

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testArea() {
        assert circles.length == areas.length;
        System.out.printf("%s\n", Feedback.formatBanner("testArea"));
        for (int i = 0; i < circles.length; i++) {
 //HIDE
            Circle circle = circles[i];
            double area = areas[i];
            System.out.printf("(%s).area() \u2192 %.5e\n",
                circle.repr(), circle.area());
            Assert.assertEquals(String.format("(%s).area()", circle.repr()),
                area, circle.area(), area / Circle.TOLERANCE);
            //EDIT // Give feedback on area and use method from Assert to test.
        }
    }

    @Test
    public void testPoints() {
        assert circles.length == points.length;
        assert circles.length == isOns.length;
        System.out.printf("%s\n", Feedback.formatBanner("testPoints"));
        for (int i = 0; i < circles.length; i++) {
//HIDE
            Circle circle = circles[i];
            double x = points[i][0], y = points[i][1];
            System.out.printf("(%s).isOn(%s,%s) \u2192 %s\n",
                circle.repr(), x, y, circle.isOn(x, y));
            Assert.assertEquals(String.format("(%s).isOn(%s,%s)", circle.repr(), x, y),
                isOns[i], circle.isOn(x, y));
            //EDIT // Give feedback on isOn and use method from Assert to test.
        }
    }
}