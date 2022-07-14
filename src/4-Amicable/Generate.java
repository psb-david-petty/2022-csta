/*
 * Generate.java
 *
 * Class for generating test data.
 *
 * @author David C. Petty // http://j.mp/psb_david_petty
 */
import java.util.*;

public class Generate {
    private static int SIZE = 200000;

    public static void main(String[] args) {
        List<Integer> sums = new ArrayList<Integer>();
        for (int i = 0; i <= 100; i++)
            sums.add(Amicable.sumProperDivisors(i));
        System.out.println(Format.format1D(sums, "sums", Format.Mod.PRIVATE));

        // https://oeis.org/A002025 & https://oeis.org/A002046
        System.out.printf("// Create map of proper divisors...\n");
        Map<Integer, Integer> spd = new HashMap<Integer, Integer>();
        for (int n = 0; n < SIZE; n++) {
            spd.put(n, Amicable.sumProperDivisors(n));
        }
        System.out.printf("// Create lists...\n");
        List<Integer> minima = new ArrayList<Integer>();
        List<Integer> maxima = new ArrayList<Integer>();
        List<Boolean> amicable = new ArrayList<Boolean>();
        for (int i = 1; i < SIZE; i++) {
            for (int j = i; j < SIZE && j <= spd.get(i); j++) {
                if (i == spd.get(j) && j == spd.get(i)) {
                    minima.add(i);
                    maxima.add(j);
                    amicable.add(true);
                }
            }
        }
        for (int n : new int[] { 10, 100, 1000, 10000, 100000, }) {
            minima.add(n);
            maxima.add(n * 47);
            amicable.add(false);
        }

        // Output generated test data.
        System.out.println(Format.format1D(minima, "minima", Format.Mod.PRIVATE));
        System.out.println(Format.format1D(maxima, "maxima", Format.Mod.PRIVATE));
        System.out.println(Format.format1D(amicable, "amicable", Format.Mod.PRIVATE));
    }
}