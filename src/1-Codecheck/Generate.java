/*
 * Generate.java
 *
 * Class for generating test data for CodecheckCube.java and CodecheckSquare.java.
 *
 * @author David C. Petty // http://j.mp/psb_david_petty
 */
import java.util.*;

public class Generate {
    public static void main(String[] args) {
        List<List<Integer>> squares = new ArrayList<>();
        squares.add(Arrays.asList(0, 0));
        for (int n = 1; n < Math.sqrt(Integer.MAX_VALUE); n *= 2) {
            squares.add(Arrays.asList(n, n * n));
        }
        List<List<Integer>> cubes = new ArrayList<>();
        cubes.add(Arrays.asList(0, 0));
        for (int n = 1; n < Math.pow(Integer.MAX_VALUE, 1.0 / 3); n *= 2) {
            cubes.add(Arrays.asList(n, n * n * n));
        }

        // Output generated test data.
        System.out.printf("        // powers of two and their squares\n%s\n",
            Format.format2D(squares, "squares"));
        System.out.printf("        // powers of two and their cubes\n%s\n",
            Format.format2D(cubes, "cubes"));
    }
}
