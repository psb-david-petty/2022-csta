/*
 * Math.java
 *
 * Replacements for java.lang.Math with repeatable seeded Random.
 * Only methods listed on College Board APCS-A Java Quick Reference.
 * https://apstudents.collegeboard.org/ap/pdf/ap-computer-science-a-java-quick-reference_0.pdf
 *
 * @author David C. Petty // http://j.mp/psb_david_petty
 */
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Random;

public class Math {
    private static Random random;
    public static int abs(int x) { return java.lang.Math.abs(x); }
    public static double abs(double x) { return java.lang.Math.abs(x); }
    public static double pow(double base, double exponent) { return java.lang.Math.pow(base, exponent); }
    public static double sqrt(double x) { return java.lang.Math.sqrt(x); }
    public static double random() { if (random == null) init(47); return random.nextDouble(); }
    public static void init(long seed) { random = new Random(seed); }
}
