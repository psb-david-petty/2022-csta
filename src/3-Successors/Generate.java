/*
 * Generate.java
 *
 * Class for generating test data for Successors.java.
 *
 * @author David C. Petty // http://j.mp/psb_david_petty
 */
import java.util.*;
public class Generate {
    public static void main(String[] args) {
        // College Board examples plus ragged array example.
        int[][][] ias = new int[][][]{                  // input arrays
            {
                {15, 5, 9, 10,},
                {12, 16, 11, 6,},
                {14, 8, 13, 7,},
            },
            {
                {47,},
                {48, 49,},
                {50, 51, 52,},
                {53, 54,},
                {55,},
            },
        };
        int[][] ras = new int[][] {                     // range arrays
            {  5, 16, },// range of values in ias[0]
            { 47, 55, },// range of values in ias[1]
        };

        // Generate positions in the inclusive range of ras[i] for inputs[i].
        List<List<Position>> pls = new ArrayList<>();   // position lists
        for (int i = 0; i < ias.length; i++) {
//HIDE
            List<Position> ps = new ArrayList<Position>();
            pls.add(ps);
            int start = ras[i][0], end = ras[i][1];
            for (int j = start; j < end; j++)
                ps.add(Successors.findPosition(j, ias[i]));
            //EDIT // Use findPosition to generate test data for all ias range values.
        }

        // Generate successor arrays for each input[i].
        Position[][][] successorArrays = new Position[ias.length][][];
        for (int i = 0; i < ias.length; i++)
            successorArrays[i] = Successors.getSuccessorArray(ias[i]);

        // Output generated test data.
        System.out.printf("%s\n", Format.format3Dint(ias, "ias", Format.Mod.PRIVATE));
        System.out.printf("%s\n", Format.format2Dint(ras, "ras", Format.Mod.PRIVATE));
        System.out.printf("%s\n", Format.format2D(pls, "pas", Format.Mod.PRIVATE));
        System.out.printf("%s\n", Format.format3DObject(successorArrays, "sas", Format.Mod.PRIVATE));
    }
}