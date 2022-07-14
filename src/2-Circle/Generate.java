/*
 * Generate.java
 *
 * Class for generating test data for Circle.java.
 *
 * @author David C. Petty // http://j.mp/psb_david_petty
 */
import java.util.*;

public class Generate {
    public static final int LIMIT = 6;
    public static final int STEP = 2;
    public static final double INC = 0.5;
    public static void main(String[] args) {
        List<Circle> circles = new ArrayList<Circle>();
        List<Double> areas = new ArrayList<Double>();
        // Add some test circles.
//HIDE
        circles.add(new Circle(0, 0, 10));
        circles.add(new Circle(100, 100, 100));
        circles.add(new Circle(3, 4, 5));

        // Generate area test data
        for (Circle circle: circles) {
            areas.add(Math.round(circle.area() * Circle.TOLERANCE) / Circle.TOLERANCE);
        }

        // Generate isOn test data.
        double[][] points = new double[circles.size()][];
        List<Boolean> isOns = new ArrayList<Boolean>();
        int sign = 1;
        for (int i = 0; i < circles.size(); i++) {
            Circle circle = circles.get(i);
            double x = circle.getX(), y = circle.getY(), r = circle.getR();
            double eps = sign * r / Circle.TOLERANCE * 0.99;
            if (sign > 0)
                x = x + sign * r + eps;
            else
                y = y + sign * r + eps;
            points[i] = new double[] { x, y, };
            isOns.add(circle.isOn(x, y));
            sign *= -1;
        }

        //EDIT // Add your code that generates test data

        // Output generated test data.
        System.out.printf("%s\n",
            Format.format1D(circles, "circles", Format.Mod.PRIVATE));
        System.out.printf("%s\n",
            Format.format1D(areas, "areas", Format.Mod.PRIVATE));
        System.out.printf("%s\n",
            Format.format2Ddouble(points, "points", Format.Mod.PRIVATE));
        System.out.printf("%s\n",
            Format.format1D(isOns, "isOns", Format.Mod.PRIVATE));
    }
}
