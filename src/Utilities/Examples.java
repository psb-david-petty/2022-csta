/*
 * Examples.java
 *
 * Class for generating examples for Utilities.java.
 *
 * @author David C. Petty // http://j.mp/psb_david_petty
 */
import java.util.*;

public class Examples {
    public static void main(String[] args) {
        System.out.printf("%s\n", Utilities.format1D(
            Arrays.asList(
                Math.random(), Math.random(), Math.random(), Math.random(), Math.random(),
                Math.random(), Math.random(), Math.random(), Math.random(), Math.random()),
            "rand", Utilities.Mod.PUBLIC));
        System.out.printf("%s\n", Utilities.format2D(
            Arrays.asList(
                Arrays.asList(' ', ' ', ' ', ' ', ' ', ' ', ' '),
                Arrays.asList(' ', ' ', ' ', ' ', ' ', ' ', ' '),
                Arrays.asList(' ', ' ', ' ', ' ', ' ', ' ', ' ')),
            "ticTacToe", Utilities.Mod.PRIVATE));
        System.out.printf("%s\n", Utilities.format3D(
            Arrays.asList(
                Arrays.asList(
                    Arrays.asList("A", "B", "C", "E", "F", "G", "H", "I", "J", "K", "L", "M"),
                    Arrays.asList("N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y")
                ),
                Arrays.asList(
                    Arrays.asList("A", "B", "C", "E", "F", "G", "H", "I", "J", "K", "L", "M"),
                    Arrays.asList("N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y")
                ),
                Arrays.asList(
                    Arrays.asList("A", "B", "C", "E", "F", "G", "H", "I", "J", "K", "L", "M"),
                    Arrays.asList("N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y")
                ),
                Arrays.asList(
                    Arrays.asList("A", "B", "C", "E", "F", "G", "H", "I", "J", "K", "L", "M"),
                    Arrays.asList("N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y"))),
            "alpha", Utilities.Mod.PROTECTED));

        List<Boolean> booll = new ArrayList<Boolean>();
        booll.add(false); booll.add(true);
        System.out.printf("%s\n", Utilities.format1D(booll, "booll", Utilities.Mod.LOCAL));

        List<String> strl = new ArrayList<String>();
        strl.add("one"); strl.add("two"); strl.add("three"); strl.add("four"); strl.add("five");
        System.out.printf("%s\n", Utilities.format1D(strl, "strl", Utilities.Mod.PUBLIC));

        List<Character> cl = new ArrayList<Character>();
        cl.add('à'); cl.add(' '); cl.add('l'); cl.add('a'); cl.add(' '); cl.add('m'); cl.add('o'); cl.add('d'); cl.add('e');
        System.out.printf("%s\n", Utilities.format1D(cl, "cl"));

        List<Byte> bl = new ArrayList<Byte>();
        bl.add((byte) 1); bl.add((byte) 2); bl.add((byte) 3); bl.add((byte) 4); bl.add((byte) 5);
        System.out.printf("%s\n", Utilities.format1D(bl, "bl", Utilities.Mod.PRIVATE));

        List<Short> sl = new ArrayList<Short>();
        sl.add((short) 1); sl.add((short) 2); sl.add((short) 3); sl.add((short) 4); sl.add((short) 5);
        System.out.printf("%s\n", Utilities.format1D(sl, "sl", Utilities.Mod.PROTECTED));

        List<Integer> il = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) il.add(i);
        System.out.printf("%s\n", Utilities.format1D(il, "il", Utilities.Mod.PACKAGE));

        List<Long> ll = new ArrayList<Long>();
        ll.add(1L); ll.add(2L); ll.add(3L); ll.add(4L); ll.add(5L);
        System.out.printf("%s\n", Utilities.format1D(ll, "ll"));

        List<Float> fl = new ArrayList<Float>();
        fl.add(1F); fl.add(2F); fl.add(3F); fl.add(4F); fl.add(5F);
        System.out.printf("%s\n", Utilities.format1D(fl, "fl", Utilities.Mod.PUBLIC));

        List<Double> dl = new ArrayList<Double>();
        dl.add(1.); dl.add(2.); dl.add(3.); dl.add(4.); dl.add(5.);
        System.out.printf("%s\n", Utilities.format1D(dl, "dl", Utilities.Mod.PRIVATE));

        List<Point> pl = new ArrayList<Point>();
        pl.add(new Point());
        for (int i = 1; i < 10; i++)
            pl.add(new Point(i * 47,i * 47));
        System.out.printf("%s\n", Utilities.format1D(pl, "pl", Utilities.Mod.PROTECTED));

        System.out.printf("%s\n", Utilities.format1Dint(new int[] {
                47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47,
                47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47,
        }, "ctf"));

        System.out.printf("%s\n", Utilities.format1Dlong(new long[] {
                47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47,
                47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47,
        }, "ctfl", Utilities.Mod.PACKAGE));

        System.out.printf("%s\n", Utilities.format1Ddouble(new double[] {
                47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47,
                47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47,
        }, "ctfd", Utilities.Mod.PROTECTED));

        System.out.printf("%s\n", Utilities.format2Ddouble(new double[][] {
            { 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, },
            { 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, },
        }, "ctfdd", Utilities.Mod.LOCAL));

        System.out.printf("%s\n", Utilities.format3Dlong(new long[][][] {
            { { 2, 7, 6, }, { 9, 5, 1, }, { 4, 3, 8, }, },
            { { 4, 9, 2, }, { 3, 5, 7, }, { 8, 1, 6, }, },
            { { 2, 7, 12, 13, }, { 16, 9, 6, 3, },
                { 5, 4, 15, 10, }, { 11, 14, 1, 8, }, },
        }, "magicl", Utilities.Mod.LOCAL));
    }
}