/*
 * CircleI.java
 *
 * @author David C. Petty // http://j.mp/psb_david_petty
 */

public interface CircleI {
    /** Calculations have accuracy of one part in TOLERANCE */
    public static final double TOLERANCE = 10000;
    double getX();
    double getY();
    double getR();
    double area();
    boolean isOn(double x, double y);
}