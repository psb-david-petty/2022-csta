/*
 * Circle.java
 *
//HIDE
 * @author David C. Petty // http://j.mp/psb_david_petty
 //EDIT * @author YOUR NAME <your@email.address>
 */

public class Circle implements CircleI {
    private double x, y, r;
//HIDE
    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public double getX() { return x; }
    public double getY() { return y; }
    public double getR() { return r; }

    public double area() {
        return Math.PI * r * r;
    }
    public boolean isOn(double x, double y) {
        final double dx = this.x - x, dy = this.y - y, eps = r / TOLERANCE;
        double d = Math.sqrt(dx * dx + dy * dy);
        return Math.abs(d - r) <= eps;
    }

    //EDIT // Add your code that implements CircleI

    public String toString() {
        return String.format("Circle(%s,%s,%s)", x, y, r);
    }
    public String repr() {
        return String.format("new %s", toString());
    }
}