/*
 * Format.java
 *
 * Static generation utility methods.
 *
 * @author David C. Petty // http://j.mp/psb_david_petty
 */

import java.util.*;
import java.util.stream.*;
import java.lang.reflect.*;

/** Format has static methods for formatting unit-test data.
 * <p>
 * TODO: Correctly format javadoc comments w/ <code>&lt;code&gt;</code> tags
 */
public final class Format {
    private static final String FORMAT_DATA = "{%s%s%s%s}";
    private static final String FORMAT_ARRAY = "%s%s%s = %s%s;\n";
    private static final String FORMAT_LHS = "%sstatic %s%s ";
    private static final String FORMAT_RHS = "new %s%s ";
    private static final String INDENT = "    ", DELIM = ", ", NL = "\n";
    /** Maximum output characters-per-line. */
    public static final int WIDTH = 72;

    /** Format has only static methods */
    private Format() { super(); }

    /**
     * Enum for field / local modifiers.
     * Mod includes the method / field access modifiers public, private,
     * protected, and package (default), plus one for local variables.
     * The mod String field includes the text plus appropriate spaces.
     * <p>
     * TODO: Format.Mod.LOCAL should only be used to indicate a local variable
     */
    public enum Mod {
        PUBLIC("public "),
        PRIVATE("private "),
        PROTECTED("protected "),
        PACKAGE(""),
        LOCAL("INVALID");   // TODO: Format.Mod.LOCAL.mod is invalid

        public final String mod;

        private Mod(String mod) {
            this.mod = mod;
        }
    }

    /**
     * Local EmptyList RuntimeException.
     * All lists of parameters must be non-empty, because at least one element
     * is needed to ascertain the class.
     */
    public static final class EmptyList extends RuntimeException {
        EmptyList() {
            super("list cannot be empty");
        }
        EmptyList(String message) {
            super(message);
        }
    }

    /**
     * Return n copies of INDENT concatenated.
     *
     * @param n number of INDENT strings to concatenate
     * @return n copies of INDENT concatenated
     */
    private static String nIndents(int n) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(INDENT);
        return sb.toString();
    }

    /**
     * Return list1D formatted as a literal array string indented indent times.
     *
     * @param list1D 1D list to be formatted as a literal array string
     * @param indent number of times to indent literal array string
     * @return string list1D formatted as a literal array string indented indent times
     */
    private static String format1DString(List<?> list1D, int indent) {
        List<String> reprs = new ArrayList<String>();
        for (Object obj : list1D) {
            reprs.add(repr(obj));
        }
        StringBuilder sb = new StringBuilder(nIndents(indent + 1));
        for (int i = 0, s = 0; i < reprs.size(); i++) {
            //System.out.printf("%s %s %s\n", len, s, sb);
            if (sb.length() - s + reprs.get(i).length() > WIDTH) {
                sb.append('\n');
                s = sb.length();
                sb.append(nIndents(indent + 1));
            }
            sb.append(reprs.get(i));
        }
        sb.setLength(sb.length() - 1);
        // TODO: allow for a one-line initializer
        return String.format(FORMAT_DATA, NL, sb, NL, nIndents(indent));
    }

    /**
     * Return list2D formatted as a literal array string indented indent times.
     *
     * @param list2D 2D list to be formatted as a literal array string
     * @param indent number of times to indent literal array string
     * @return string list2D formatted as a literal array string indented indent times
     */
    private static String format2DString(List<? extends List<?>> list2D, int indent) {
        List<String> reprs = new ArrayList<String>();
        for (List list1D : list2D) {
            reprs.add(format1DString(list1D, indent + 1));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < reprs.size(); i++) {
            sb.append(nIndents(indent + 1)).append(reprs.get(i)).append(DELIM).append('\n');
        }
        sb.setLength(sb.length() - 1);
        return String.format(FORMAT_DATA, NL, sb, NL, nIndents(indent));
    }

    /**
     * Return list3D formatted as a literal array string indented indent times.
     *
     * @param list3D 1D list to be formatted as a literal array string
     * @param indent number of times to indent literal array string
     * @return string list3D formatted as a literal array string indented indent times
     */
    private static String format3DString(List<? extends List<? extends List<?>>> list3D, int indent) {
        List<String> reprs = new ArrayList<String>();
        for (List<? extends List<?>> list2D : list3D) {
            reprs.add(format2DString(list2D, indent + 1));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < reprs.size(); i++) {
            sb.append(nIndents(indent + 1)).append(reprs.get(i)).append(DELIM).append('\n');
        }
        sb.setLength(sb.length() - 1);
        return String.format(FORMAT_DATA, NL, sb, NL, nIndents(indent));
    }

    ///////////////////////////////// 1D /////////////////////////////////

    /**
     * Return string representation of 1D array of objects suitable for compiling.
     * format1D declares and initializes a literal 1D array of elements from list
     * using literal forms of String or primitive types with literal forms
     * (boolean, char, byte, short, int, long, float, double) or an object-
     * constructing form using new. The literal array initializer is formatted
     * as an assignment to a local field reference (when modifier is Mod.LOCAL)
     * or as a static field declaration, otherwise.
     *
     * @param list     1D list of objects to prepare for a literal 1D array initializer
     * @param name     name of variable for literal 1D array assignment
     * @param modifier one of Mod.mod access modifiers, unless Mod.LOCAL
     * @return string representation of 1D array suitable for compiling
     */
    public static String format1D(List<?> list, String name, Mod modifier) {
        if (list.size() == 0) throw new EmptyList();
        int indent = modifier.equals(Mod.LOCAL) ? 2 : 1;
        String className = getType(list);
        String declaration = modifier.equals(Mod.LOCAL) ? "" :
            String.format(FORMAT_LHS, modifier.mod, className, "[]");
        String initializer = !modifier.equals(Mod.LOCAL) ? "" :
            String.format(FORMAT_RHS, className, "[]");
        return String.format(FORMAT_ARRAY, nIndents(indent),
            declaration, name, initializer, format1DString(list, indent));
    }

    /**
     * Return string representation of 1D array of objects suitable for compiling.
     * format1D declares and initializes a literal 1D array of elements from list
     * as an assignment to a local field reference as with {@link #format1D(List, String, Mod)
     * three-parameter format1D}.
     *
     * @param list 1D list of objects to prepare for a literal 1D array initializer
     * @param name name of variable for literal 1D array assignment
     * @return string representation of 1D array suitable for compiling
     */
    public static String format1D(List<?> list, String name) {
        return format1D(list, name, Mod.LOCAL);
    }

    /**
     * Return string representation of 1D array of ints suitable for compiling.
     * format1Dint declares and initializes a literal 1D array of elements from arr
     * as with {@link #format1D(List, String, Mod) format1D}.
     *
     * @param arr 1D array of ints to prepare for a literal 1D array initializer
     * @param name name of variable for literal 1D array assignment
     * @param modifier one of Mod.mod access modifiers, unless Mod.LOCAL
     * @return string representation of 1D array suitable for compiling
     */
    public static String format1Dint(int[] arr, String name, Mod modifier) {
        return format1D(Arrays.stream(arr).boxed().collect(Collectors.toList()), name, modifier);
    }

    /**
     * Return string representation of 1D array of ints suitable for compiling.
     * format1Dint declares and initializes a literal 1D array of elements from arr
     * as with {@link #format1D(List, String) format1D}.
     *
     * @param arr 1D array of ints to prepare for a literal 1D array initializer
     * @param name name of variable for literal 1D array assignment
     * @return string representation of 1D array suitable for compiling
     */
    public static String format1Dint(int[] arr, String name) {
        return format1Dint(arr, name, Mod.LOCAL);
    }

    /**
     * Return string representation of 1D array of ints suitable for compiling.
     * format1Dlong declares and initializes a literal 1D array of elements from arr
     * as with {@link #format1D(List, String, Mod) format1D}.
     *
     * @param arr 1D array of ints to prepare for a literal 1D array initializer
     * @param name name of variable for literal 1D array assignment
     * @param modifier one of Mod.mod access modifiers, unless Mod.LOCAL
     * @return string representation of 1D array suitable for compiling
     */
    public static String format1Dlong(long[] arr, String name, Mod modifier) {
        return format1D(Arrays.stream(arr).boxed().collect(Collectors.toList()), name, modifier);
    }

    /**
     * Return string representation of 1D array of longs suitable for compiling.
     * format1Dlong declares and initializes a literal 1D array of elements from arr
     * as with {@link #format1D(List, String) format1D}.
     *
     * @param arr 1D array of longs to prepare for a literal 1D array initializer
     * @param name name of variable for literal 1D array assignment
     * @return string representation of 1D array suitable for compiling
     */
    public static String format1Dlong(long[] arr, String name) {
        return format1Dlong(arr, name, Mod.LOCAL);
    }

    /**
     * Return string representation of 1D array of doubles suitable for compiling.
     * format1Ddouble declares and initializes a literal 1D array of elements from arr
     * as with {@link #format1D(List, String, Mod) format1D}.
     *
     * @param arr 1D array of doubles to prepare for a literal 1D array initializer
     * @param name name of variable for literal 1D array assignment
     * @param modifier one of Mod.mod access modifiers, unless Mod.LOCAL
     * @return string representation of 1D array suitable for compiling
     */
    public static String format1Ddouble(double[] arr, String name, Mod modifier) {
        return format1D(Arrays.stream(arr).boxed().collect(Collectors.toList()), name, modifier);
    }

    /**
     * Return string representation of 1D array of doubles suitable for compiling.
     * format1Ddouble declares and initializes a literal 1D array of elements from arr
     * as with {@link #format1D(List, String) format1D}.
     *
     * @param arr 1D array of doubles to prepare for a literal 1D array initializer
     * @param name name of variable for literal 1D array assignment
     * @return string representation of 1D array suitable for compiling
     */
    public static String format1Ddouble(double[] arr, String name) {
        return format1Ddouble(arr, name, Mod.LOCAL);
    }

    ///////////////////////////////// 2D /////////////////////////////////

    /**
     * Return string representation of 2D array of objects suitable for compiling.
     * format2D declares and initializes a literal 2D array of elements from list
     * using literal forms of String or primitive types with literal forms
     * (boolean, char, byte, short, int, long, float, double) or an object-
     * constructing form using new. The literal array initializer is formatted
     * as an assignment to a local field reference (when modifier is Mod.LOCAL)
     * or as a static field declaration, otherwise.
     *
     * @param list     2D list of objects to prepare for a literal 2D array initializer
     * @param name     name of variable for literal 2D array assignment
     * @param modifier one of Mod.mod access modifiers, unless Mod.LOCAL
     * @return string representation of 2D array suitable for compiling
     */
    public static String format2D(List<? extends List<?>> list, String name, Mod modifier) {
        if (list.size() == 0 || list.get(0).size() == 0) throw new EmptyList();
        int indent = modifier.equals(Mod.LOCAL) ? 2 : 1;
        String className = getType(list);
        String declaration = modifier.equals(Mod.LOCAL) ? "" :
            String.format(FORMAT_LHS, modifier.mod, className, "[][]");
        String initializer = !modifier.equals(Mod.LOCAL) ? "" :
            String.format(FORMAT_RHS, className, "[][]");
        return String.format(FORMAT_ARRAY, nIndents(indent),
            declaration, name, initializer, format2DString(list, indent));
    }

    /**
     * Return string representation of 2D array of objects suitable for compiling.
     * format2D declares and initializes a literal 2D array of elements from list
     * as an assignment to a local field reference as with {@link #format2D(List, String, Mod)
     * three-parameter format2D}.
     *
     * @param list 2D list of objects to prepare for a literal 2D array initializer
     * @param name name of variable for literal 2D array assignment
     * @return string representation of 2D array suitable for compiling
     */
    public static String format2D(List<?extends List<?>> list, String name) {
        return format2D(list, name, Mod.LOCAL);
    }

    /**
     * Return string representation of 2D array of ints suitable for compiling.
     * format2Dint declares and initializes a literal 2D array of elements from arr
     * as with {@link #format2D(List, String, Mod) format2D}.
     *
     * @param arr 2D array of ints to prepare for a literal 2D array initializer
     * @param name name of variable for literal 2D array assignment
     * @param modifier one of Mod.mod access modifiers, unless Mod.LOCAL
     * @return string representation of 2D array suitable for compiling
     */
    public static String format2Dint(int[][] arr, String name, Mod modifier) {
        List<List<?>> list2D = new ArrayList<List<?>>();
        for (int[] arr1D: arr)
            list2D.add(Arrays.stream(arr1D).boxed().collect(Collectors.toList()));
        return format2D(list2D, name, modifier);
    }

    /**
     * Return string representation of 2D array of ints suitable for compiling.
     * format2Dint declares and initializes a literal 2D array of elements from arr
     * as with {@link #format2D(List, String) format2D}.
     *
     * @param arr 2D array of ints to prepare for a literal 2D array initializer
     * @param name name of variable for literal 2D array assignment
     * @return string representation of 2D array suitable for compiling
     */
    public static String format2Dint(int[][] arr, String name) {
        return format2Dint(arr, name, Mod.LOCAL);
    }

    /**
     * Return string representation of 2D array of ints suitable for compiling.
     * format2Dlong declares and initializes a literal 2D array of elements from arr
     * as with {@link #format2D(List, String, Mod) format2D}.
     *
     * @param arr 2D array of ints to prepare for a literal 2D array initializer
     * @param name name of variable for literal 2D array assignment
     * @param modifier one of Mod.mod access modifiers, unless Mod.LOCAL
     * @return string representation of 2D array suitable for compiling
     */
    public static String format2Dlong(long[][] arr, String name, Mod modifier) {
        List<List<?>> list2D = new ArrayList<List<?>>();
        for (long[] arr1D: arr)
            list2D.add(Arrays.stream(arr1D).boxed().collect(Collectors.toList()));
        return format2D(list2D, name, modifier);
    }

    /**
     * Return string representation of 2D array of longs suitable for compiling.
     * format2Dlong declares and initializes a literal 2D array of elements from arr
     * as with {@link #format2D(List, String) format2D}.
     *
     * @param arr 2D array of longs to prepare for a literal 2D array initializer
     * @param name name of variable for literal 2D array assignment
     * @return string representation of 2D array suitable for compiling
     */
    public static String format2Dlong(long[][] arr, String name) {
        return format2Dlong(arr, name, Mod.LOCAL);
    }

    /**
     * Return string representation of 2D array of doubles suitable for compiling.
     * format2Ddouble declares and initializes a literal 2D array of elements from arr
     * as with {@link #format2D(List, String, Mod) format2D}.
     *
     * @param arr 2D array of doubles to prepare for a literal 2D array initializer
     * @param name name of variable for literal 2D array assignment
     * @param modifier one of Mod.mod access modifiers, unless Mod.LOCAL
     * @return string representation of 2D array suitable for compiling
     */
    public static String format2Ddouble(double[][] arr, String name, Mod modifier) {
        List<List<?>> list2D = new ArrayList<List<?>>();
        for (double[] arr1D: arr)
            list2D.add(Arrays.stream(arr1D).boxed().collect(Collectors.toList()));
        return format2D(list2D, name, modifier);
    }

    /**
     * Return string representation of 2D array of doubles suitable for compiling.
     * format2Ddouble declares and initializes a literal 2D array of elements from arr
     * as with {@link #format2D(List, String) format2D}.
     *
     * @param arr 2D array of doubles to prepare for a literal 2D array initializer
     * @param name name of variable for literal 2D array assignment
     * @return string representation of 2D array suitable for compiling
     */
    public static String format2Ddouble(double[][] arr, String name) {
        return format2Ddouble(arr, name, Mod.LOCAL);
    }

    ///////////////////////////////// 3D /////////////////////////////////

    /**
     * Return string representation of 3D array of objects suitable for compiling.
     * format3D declares and initializes a literal 3D array of elements from list
     * using literal forms of String or primitive types with literal forms
     * (boolean, char, byte, short, int, long, float, double) or an object-
     * constructing form using new. The literal array initializer is formatted
     * as an assignment to a local field reference (when modifier is Mod.LOCAL)
     * or as a static field declaration, otherwise.
     *
     * @param list     3D list of objects to prepare for a literal 3D array initializer
     * @param name     name of variable for literal 3D array assignment
     * @param modifier one of Mod.mod access modifiers, unless Mod.LOCAL
     * @return string representation of 3D array suitable for compiling
     */
    public static String format3D(List<? extends List<? extends List<?>>> list, String name, Mod modifier) {
        if (list.size() == 0 || list.get(0).size() == 0 || list.get(0).get(0).size() == 0) throw new EmptyList();
        int indent = modifier.equals(Mod.LOCAL) ? 2 : 1;
        String className = getType(list);
        String declaration = modifier.equals(Mod.LOCAL) ? "" :
            String.format(FORMAT_LHS, modifier.mod, className, "[][][]");
        String initializer = !modifier.equals(Mod.LOCAL) ? "" :
            String.format(FORMAT_RHS, className, "[][][]");
        return String.format(FORMAT_ARRAY, nIndents(indent),
            declaration, name, initializer, format3DString(list, indent));
    }

    /**
     * Return string representation of 3D array of objects suitable for compiling.
     * format3D declares and initializes a literal 3D array of elements from list
     * as an assignment to a local field reference as with {@link #format3D(List, String, Mod)
     * three-parameter format3D}.
     *
     * @param list 3D list of objects to prepare for a literal 3D array initializer
     * @param name name of variable for literal 3D array assignment
     * @return string representation of 3D array suitable for compiling
     */
    public static String format3D(List<? extends List<? extends List<?>>> list, String name) {
        return format3D(list, name, Mod.LOCAL);
    }

    /**
     * Return string representation of 3D array of ints suitable for compiling.
     * format3Dint declares and initializes a literal 3D array of elements from arr
     * as with {@link #format3D(List, String, Mod) format3D}.
     *
     * @param arr 3D array of ints to prepare for a literal 3D array initializer
     * @param name name of variable for literal 3D array assignment
     * @param modifier one of Mod.mod access modifiers, unless Mod.LOCAL
     * @return string representation of 3D array suitable for compiling
     */
    public static String format3Dint(int[][][] arr, String name, Mod modifier) {
        // TODO: there is probably a way to do this with Arrays.stream
        List<List<List<?>>> list3D = new ArrayList<List<List<?>>>();
        for (int[][] arr2D: arr) {
            List<List<?>> list2D = new ArrayList<List<?>>();
            for (int[] arr1D : arr2D)
                list2D.add(Arrays.stream(arr1D).boxed().collect(Collectors.toList()));
            list3D.add(list2D);
        }
        return format3D(list3D, name, modifier);
    }

    /**
     * Return string representation of 3D array of ints suitable for compiling.
     * format3Dint declares and initializes a literal 3D array of elements from arr
     * as with {@link #format3D(List, String) format3D}.
     *
     * @param arr 3D array of ints to prepare for a literal 3D array initializer
     * @param name name of variable for literal 3D array assignment
     * @return string representation of 3D array suitable for compiling
     */
    public static String format3Dint(int[][][] arr, String name) {
        return format3Dint(arr, name, Mod.LOCAL);
    }

    /**
     * Return string representation of 3D array of ints suitable for compiling.
     * format3Dlong declares and initializes a literal 3D array of elements from arr
     * as with {@link #format3D(List, String, Mod) format3D}.
     *
     * @param arr 3D array of ints to prepare for a literal 3D array initializer
     * @param name name of variable for literal 3D array assignment
     * @param modifier one of Mod.mod access modifiers, unless Mod.LOCAL
     * @return string representation of 3D array suitable for compiling
     */
    public static String format3Dlong(long[][][] arr, String name, Mod modifier) {
        // TODO: there is probably a way to do this with Arrays.stream
        List<List<List<?>>> list3D = new ArrayList<List<List<?>>>();
        for (long[][] arr2D: arr) {
            List<List<?>> list2D = new ArrayList<List<?>>();
            for (long[] arr1D : arr2D)
                list2D.add(Arrays.stream(arr1D).boxed().collect(Collectors.toList()));
            list3D.add(list2D);
        }
        return format3D(list3D, name, modifier);
    }

    /**
     * Return string representation of 3D array of longs suitable for compiling.
     * format3Dlong declares and initializes a literal 3D array of elements from arr
     * as with {@link #format3D(List, String) format3D}.
     *
     * @param arr 3D array of longs to prepare for a literal 3D array initializer
     * @param name name of variable for literal 3D array assignment
     * @return string representation of 3D array suitable for compiling
     */
    public static String format3Dlong(long[][][] arr, String name) {
        return format3Dlong(arr, name, Mod.LOCAL);
    }

    /**
     * Return string representation of 3D array of doubles suitable for compiling.
     * format3Ddouble declares and initializes a literal 3D array of elements from arr
     * as with {@link #format3D(List, String, Mod) format3D}.
     *
     * @param arr 3D array of doubles to prepare for a literal 3D array initializer
     * @param name name of variable for literal 3D array assignment
     * @param modifier one of Mod.mod access modifiers, unless Mod.LOCAL
     * @return string representation of 3D array suitable for compiling
     */
    public static String format3Ddouble(double[][][] arr, String name, Mod modifier) {
        // TODO: there is probably a way to do this with Arrays.stream
        List<List<List<?>>> list3D = new ArrayList<List<List<?>>>();
        for (double[][] arr2D: arr) {
            List<List<?>> list2D = new ArrayList<List<?>>();
            for (double[] arr1D : arr2D)
                list2D.add(Arrays.stream(arr1D).boxed().collect(Collectors.toList()));
            list3D.add(list2D);
        }
        return format3D(list3D, name, modifier);
    }

    /**
     * Return string representation of 3D array of doubles suitable for compiling.
     * format3Ddouble declares and initializes a literal 3D array of elements from arr
     * as with {@link #format3D(List, String) format3D}.
     *
     * @param arr 3D array of doubles to prepare for a literal 3D array initializer
     * @param name name of variable for literal 3D array assignment
     * @return string representation of 3D array suitable for compiling
     */
    public static String format3Ddouble(double[][][] arr, String name) {
        return format3Ddouble(arr, name, Mod.LOCAL);
    }

    /**
     * Return string representation of 3D array of Objects suitable for compiling.
     * format3DObject declares and initializes a literal 3D array of elements from arr
     * as with {@link #format3D(List, String, Mod) format3D}.
     *
     * @param arr 3D array of Objects to prepare for a literal 3D array initializer
     * @param name name of variable for literal 3D array assignment
     * @param modifier one of Mod.mod access modifiers, unless Mod.LOCAL
     * @return string representation of 3D array suitable for compiling
     */
    public static String format3DObject(Object[][][] arr, String name, Mod modifier) {
        // TODO: there is probably a way to do this with Arrays.stream
        List<List<List<?>>> list3D = new ArrayList<List<List<?>>>();
        for (Object[][] arr2D: arr) {
            List<List<?>> list2D = new ArrayList<List<?>>();
            for (Object[] arr1D : arr2D)
                list2D.add(Arrays.stream(arr1D).collect(Collectors.toList()));
            list3D.add(list2D);
        }
        return format3D(list3D, name, modifier);
    }

    /**
     * Return string representation of 3D array of Objects suitable for compiling.
     * format3DObject declares and initializes a literal 3D array of elements from arr
     * as with {@link #format3D(List, String) format3D}.
     *
     * @param arr 3D array of Objects to prepare for a literal 3D array initializer
     * @param name name of variable for literal 3D array assignment
     * @return string representation of 3D array suitable for compiling
     */
    public static String format3DObject(Object[][][] arr, String name) {
        return format3DObject(arr, name, Mod.LOCAL);
    }

    /**
     * Return first non-null object in inner-most list. Throw EmptyList()
     * if any nested list is empty.
     *
     * @param list list is nested, non-empty, and contains a non-null object
     * @return first non-null object in inner-most list
     */
    private static Object getObject(List<?> list) {
        if (list.size() == 0) throw new EmptyList();
        Object zeroth = list.get(0);
        if (zeroth != null && List.class.isAssignableFrom(zeroth.getClass()))
            return getObject((List<?>) zeroth);
        for (int i = 0; i < list.size(); i++)
            if (list.get(i) != null)
                return list.get(i);
        return null;
    }

    /**
     * Return string representing type of obj. If obj is of one of eight
     * primitive types (boolean, char, byte, short, int, long, float, double)
     * that type is returned, otherwise obj's class name without java.lang.
     * Throws EmptyList("only null objects") if all objects are null.
     *
     * @param list list whose element type is being returned
     * @return string representing type of obj
     */
    private static String getType(List<?> list) {
        Object obj = getObject(list);
        if (obj == null) throw new EmptyList("only null objects");
        Class cls = obj.getClass();
        String type = cls.getName().replace("java.lang.", "");
        // Autobox where possible.
        if (cls.isInstance(Boolean.FALSE)) type = "boolean";
        if (cls.isInstance('\0')) type = "char";
        if (cls.isInstance((byte) 0)) type = "byte";
        if (cls.isInstance((short) 0)) type = "short";
        if (cls.isInstance((int) 0)) type = "int";
        if (cls.isInstance((long) 0)) type = "long";
        if (cls.isInstance((float) 0)) type = "float";
        if (cls.isInstance((double) 0)) type = "double";
        return type;
    }

    /**
     * Return representative string for creating obj. The representation will
     * either be in a literal form (String, boolean, char, byte, short, int,
     * long, float, double), or an object-constructing form using new. The
     * parameters to the constructor will either be the value returned from the
     * objects repr method, or its toString method.
     * <p>
     * TODO: an objects toString method is not always suitable for its constructor
     *
     * @param obj object to return the representation of
     * @return representative string for creating obj
     */
    private static String repr(Object obj) {
        StringBuilder sb = new StringBuilder();
        if (obj == null)
            return sb.append("null").append(DELIM).toString();
        Class cls = obj.getClass();
        String name = cls.getName().replace("java.lang.", "");
        if (cls.isInstance(""))
            sb.append(String.format("\"%s\"", obj));
        else if (cls.isInstance('\0'))  // autobox Character
            sb.append(String.format("'\\u%04x'", (int) ((Character) obj).charValue()));
        else if (cls.isInstance(Boolean.FALSE)
            // Autobox the others for comparison
            || cls.isInstance((byte) 0)
            || cls.isInstance((short) 0)
            || cls.isInstance((int) 0)
            || cls.isInstance((long) 0)
            || cls.isInstance((float) 0)
            || cls.isInstance((double) 0))
            sb.append(String.format("%s%s", obj,
                cls.isInstance((long) 0) ? "L" :
                    cls.isInstance((float) 0) ? "F" : ""));
        else {
            // TODO: will not work unless toString() is close to constructor parameters
            String repr = String.format("new %s(%s)", name, obj.toString()
                // Remove surrounding brackets for constructor parameters.
                .replaceAll("^[(\\[{]|[}\\])]$", ""));
            // Check if obj has a repr method.
            for (Method method : obj.getClass().getMethods())
                if (method.getName().equals("repr"))
                    try {
                        repr = (String) method.invoke(obj);
                    } catch (ReflectiveOperationException e) {
                        e.printStackTrace();
                    }
            // Format w/ new keyword and repr method or parameters from toString method.
            sb.append(repr);
        }
        return sb.append(DELIM).toString();
    }
}