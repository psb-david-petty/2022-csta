/*
 * Feedback.java
 *
 * Static feedback utility methods.
 *
 * @author David C. Petty // http://j.mp/psb_david_petty
 */

import java.util.*;
import java.util.stream.Collectors;

public final class Feedback {
    /**
     * Feedback has only static methods
     */
    private Feedback() {
        super();
    }

    /**
     * Return banner with label centered.
     *
     * @param label string to incorporate in the banner
     * @return banner with message centered.
     */
    public static String formatBanner(String label) {
        final String BANNER = "//////////////////////////////////";
        if (BANNER.length() * 2 - (label.length() + 2) < 0) return label;
        final int N = BANNER.length() * 2, L = label.length();
        final int LEFT = (N - L + 1) / 2, RIGHT = (N - L) / 2;
        return (new StringBuilder()).append(BANNER.substring(0, LEFT))
            .append(" ").append(label).append(" ")
            .append(BANNER.substring(0, RIGHT)).toString();
    }

    /**
     * Return sb as a String with every left bracket and every leading
     * right bracket indented.
     *
     * @param sb StringBuilder containing formatted array(s).
     * @return sb as a String with brackets properly indented.
     */
    private static String wrap(StringBuilder sb) {
        return new StringBuilder(sb.toString()
            // TODO: might not work properly if elements contain '[' or ']'
            .replaceAll("\\[", " \\[")
            .replaceAll("\n\\]", "\n \\]"))
            .insert(0, "[\n").append("]").toString();
    }

    /** Return string representation of 1D list properly indented.
     *
     * @param list 1D list to be formatted
     * @return string representation of 1D list properly indented.
     */
    public static String format1D(List<?> list) {
        final StringBuilder sb = new StringBuilder();
        for (Object obj: list)
            sb.append(obj.toString()).append(",");
        return sb.insert(0, "[").append("]").toString();
    }

    /** Return string representation of 2D list properly indented.
     *
     * @param list 2D list to be formatted
     * @return string representation of 2D list properly indented.
     */
    public static String format2D(List<? extends List<?>> list) {
        final StringBuilder sb = new StringBuilder();
        for (List<?> list1D: list)
            sb.append(format1D(list1D)).append(",\n");
        return wrap(sb);
    }

    /** Return string representation of 3D list properly indented.
     *
     * @param list 1D list to be formatted
     * @return string representation of 3D list properly indented.
     */
    public static String format3D(List<? extends List<? extends List<?>>> list) {
        final StringBuilder sb = new StringBuilder();
        for (List<? extends List<?>> list2D: list)
            sb.append(format2D(list2D)).append(",\n");
        return wrap(sb);
    }

    public static String format1Dint(int[] arr) {
        return Arrays.toString(arr).replace(", ", ",");
    }

    public static String format2Dint(int[][] arr) {
        final StringBuilder sb = new StringBuilder();
        for (int[] arr1D : arr)
            sb.append(format1Dint(arr1D)).append(",\n");
        return wrap(sb);
    }

    public static String format3Dint(int[][][] arr) {
        final StringBuilder sb = new StringBuilder();
        for (int[][] arr2D : arr)
            sb.append(format2Dint(arr2D)).append(",\n");
        return wrap(sb);
    }

    public static String format1Dlong(long[] arr) {
        return Arrays.toString(arr).replace(", ", ",");
    }

    public static String format2Dlong(long[][] arr) {
        final StringBuilder sb = new StringBuilder();
        for (long[] arr1D : arr)
            sb.append(format1Dlong(arr1D)).append(",\n");
        return wrap(sb);
    }

    public static String format3Dlong(long[][][] arr) {
        final StringBuilder sb = new StringBuilder();
        for (long[][] arr2D : arr)
            sb.append(format2Dlong(arr2D)).append(",\n");
        return wrap(sb);
    }

    public static String format1Ddouble(double[] arr) {
        return Arrays.toString(arr).replace(", ", ",");
    }

    public static String format2Ddouble(double[][] arr) {
        final StringBuilder sb = new StringBuilder();
        for (double[] arr1D : arr)
            sb.append(format1Ddouble(arr1D)).append(",\n");
        return wrap(sb);
    }

    public static String format3Ddouble(double[][][] arr) {
        final StringBuilder sb = new StringBuilder();
        for (double[][] arr2D : arr)
            sb.append(format2Ddouble(arr2D)).append(",\n");
        return wrap(sb);
    }

    public static String format1DString(String[] arr) {
        final StringBuilder sb = new StringBuilder();
        for (String str: arr)
            sb.append("\"").append(str).append("\",");
        return sb.insert(0, "[").append("]").toString();
    }

    public static String format2DString(String[][] arr) {
        final StringBuilder sb = new StringBuilder();
        for (String[] arr1D : arr)
            sb.append(format1DString(arr1D)).append(",\n");
        return wrap(sb);
    }

    public static String format3DString(String[][][] arr) {
        final StringBuilder sb = new StringBuilder();
        for (String[][] arr2D : arr)
            sb.append(format2DString(arr2D)).append(",\n");
        return wrap(sb);
    }
}
