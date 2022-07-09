/*
 * Point.java
 *
 * Standard ordered pair class including a repr method.
 *
 * @author David C. Petty // http://j.mp/psb_david_petty
 */
public class Point {
    private double x, y;
    public Point(double x, double y) { this.x = x; this.y = y; }
    public Point() { this(0, 0); }
    public double getX() { return x; }
    public double getY() { return y; }
    public double distance(Point that) {
        final double dx = this.x - that.x, dy = this.y - that.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    public String toString() { return "(" + x + "," + y + ")"; }
    public String repr() { return "new Point" + toString(); }
}
