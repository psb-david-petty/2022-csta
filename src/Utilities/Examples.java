/*
 * Examples.java
 *
 * Class for generating examples for Format.java.
 *
 * @author David C. Petty // http://j.mp/psb_david_petty
 */
import java.util.*;
import java.util.stream.Collectors;

public class Examples {
    public static void main(String[] args) {
        System.out.printf("%s\n", Feedback.formatBanner("Examples"));
        System.out.printf("%s\n", Format.format1D(
            Arrays.asList(
                Math.random(), Math.random(), Math.random(), Math.random(), Math.random(),
                Math.random(), Math.random(), Math.random(), Math.random(), Math.random()),
            "rand", Format.Mod.PUBLIC));
        System.out.printf("%s\n", Format.format2D(
            Arrays.asList(
                Arrays.asList(' ', ' ', ' ', ' ', ' ', ' ', ' '),
                Arrays.asList(' ', ' ', ' ', ' ', ' ', ' ', ' '),
                Arrays.asList(' ', ' ', ' ', ' ', ' ', ' ', ' ')),
            "ticTacToe", Format.Mod.PRIVATE));
        System.out.printf("%s\n", Format.format3D(
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
            "alpha", Format.Mod.PROTECTED));

        List<Boolean> booll = new ArrayList<Boolean>();
        booll.add(false); booll.add(true);
        System.out.printf("%s\n", Format.format1D(booll, "booll", Format.Mod.LOCAL));

        List<String> strl = new ArrayList<String>();
        strl.add("one"); strl.add("two"); strl.add("three"); strl.add("four"); strl.add("five");
        System.out.printf("%s\n", Format.format1D(strl, "strl", Format.Mod.PUBLIC));

        List<Character> cl = new ArrayList<Character>();
        cl.add('à'); cl.add(' '); cl.add('l'); cl.add('a'); cl.add(' '); cl.add('m'); cl.add('o'); cl.add('d'); cl.add('e');
        System.out.printf("%s\n", Format.format1D(cl, "cl"));

        List<Byte> bl = new ArrayList<Byte>();
        bl.add((byte) 1); bl.add((byte) 2); bl.add((byte) 3); bl.add((byte) 4); bl.add((byte) 5);
        System.out.printf("%s\n", Format.format1D(bl, "bl", Format.Mod.PRIVATE));

        List<Short> sl = new ArrayList<Short>();
        sl.add((short) 1); sl.add((short) 2); sl.add((short) 3); sl.add((short) 4); sl.add((short) 5);
        System.out.printf("%s\n", Format.format1D(sl, "sl", Format.Mod.PROTECTED));

        List<Integer> il = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) il.add(i);
        System.out.printf("%s\n", Format.format1D(il, "il", Format.Mod.PACKAGE));

        List<Long> ll = new ArrayList<Long>();
        ll.add(1L); ll.add(2L); ll.add(3L); ll.add(4L); ll.add(5L);
        System.out.printf("%s\n", Format.format1D(ll, "ll"));

        List<Float> fl = new ArrayList<Float>();
        fl.add(1F); fl.add(2F); fl.add(3F); fl.add(4F); fl.add(5F);
        System.out.printf("%s\n", Format.format1D(fl, "fl", Format.Mod.PUBLIC));

        List<Double> dl = new ArrayList<Double>();
        dl.add(1.); dl.add(2.); dl.add(3.); dl.add(4.); dl.add(5.);
        System.out.printf("%s\n", Format.format1D(dl, "dl", Format.Mod.PRIVATE));

        List<Point> pl = new ArrayList<Point>();
        pl.add(new Point());
        for (int i = 1; i < 10; i++)
            pl.add(new Point(i * 47,i * 47));
        System.out.printf("%s\n", Format.format1D(pl, "pl", Format.Mod.PROTECTED));

        System.out.printf("%s\n", Format.format1Dint(new int[] {
                47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47,
                47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47,
        }, "ctf"));

        System.out.printf("%s\n", Format.format1Dlong(new long[] {
                47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47,
                47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47,
        }, "ctfl", Format.Mod.PACKAGE));

        System.out.printf("%s\n", Format.format1Ddouble(new double[] {
                47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47,
                47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47,
        }, "ctfd", Format.Mod.PROTECTED));

        System.out.printf("%s\n", Format.format2Ddouble(new double[][] {
            { 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, },
            { 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, },
        }, "ctfdd", Format.Mod.LOCAL));

        System.out.printf("%s\n", Format.format3Dlong(new long[][][] {
            { { 2, 7, 6, }, { 9, 5, 1, }, { 4, 3, 8, }, },
            { { 4, 9, 2, }, { 3, 5, 7, }, { 8, 1, 6, }, },
            { { 2, 7, 12, 13, }, { 16, 9, 6, 3, },
                { 5, 4, 15, 10, }, { 11, 14, 1, 8, }, },
        }, "magicl", Format.Mod.LOCAL));

        String s = "";
        for (int i = 0; i < 75; i++) {
            s += "X";
            System.out.printf("%s\n", Feedback.formatBanner(s));
        }

        // Test array formatters.
        int[] arr1Dint = { 1, 2, 3, 4, 5, };
        System.out.printf("%s\n", Feedback.format1Dint(arr1Dint));
        long[] arr1Dlong = { 1, 2, 3, 4, 5, 6, };
        System.out.printf("%s\n", Feedback.format1Dlong(arr1Dlong));
        double[] arr1Ddouble = { 1, 2, 3, 4, 5, 6, 7, 8, };
        System.out.printf("%s\n", Feedback.format1Ddouble(arr1Ddouble));
        int[][] arr2Dint = { { 1, 2, 3, }, { 4, 5, 6, }, { 7, 8, 9, } };
        System.out.printf("%s\n", Feedback.format2Dint(arr2Dint));
        int[][][] arr3Dint = {
            { { 1, 2, 3, }, { 4, 5, 6, }, { 7, 8, 9, }, },
            { { 1, 2, 3, }, { 4, 5, 6, }, { 7, 8, 9, }, },
            { { 1, 2, 3, }, { 4, 5, 6, }, { 7, 8, 9, }, },
        };
        System.out.printf("%s\n", Feedback.format3Dint(arr3Dint));

        double[][][] arr3Ddouble = {
            { { 1, 2, 3, }, { 4, 5, 6, }, { 7, 8, 9, }, },
            { { 1, 2, 3, }, { 4, 5, 6, }, { 7, 8, 9, }, },
            { { 1, 2, 3, }, { 4, 5, 6, }, { 7, 8, 9, }, },
        };
        System.out.printf("%s\n", Feedback.format3Ddouble(arr3Ddouble));

        String[] arr1DString = { "FOO", "BAR", "BLAP", };
        System.out.printf("%s\n", Feedback.format1DString(arr1DString));
        String[][] arr2DString = { { "FOO", "BAR", "BLAP", }, { "BIFF", "BOFF", "BUFF", } };
        System.out.printf("%s\n", Feedback.format2DString(arr2DString));

        // Test list formatters.
        List<?> list1D = Arrays.stream(arr1Dint).boxed().collect(Collectors.toList());
        System.out.printf("%s\n", Feedback.format1D(list1D));
        List<List<?>> list2D = new ArrayList<>();
        for (int[] arr1D: arr2Dint)
            list2D.add(Arrays.stream(arr1D).boxed().collect(Collectors.toList()));
        System.out.printf("%s\n", Feedback.format2D(list2D));
        List<List<List<?>>> list3D = new ArrayList<>();
        for (int[][] arr2D: arr3Dint) {
            // TODO: there's probably a way to do this w/ streams.
            list2D = new ArrayList<>();
            list3D.add(list2D);
            for (int[] arr1D : arr2D)
                list2D.add(Arrays.stream(arr1D).boxed().collect(Collectors.toList()));
        }
        System.out.printf("%s\n", Feedback.format3D(list3D));
    }
}