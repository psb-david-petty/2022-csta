/*
 * Successors.java
 *
//HIDE
 * @author David C. Petty // http://j.mp/psb_david_petty
 //EDIT * @author YOUR NAME <your@email.address>
 */
//ID Successors

/**
 * This question involves reasoning about a two-dimensional (2D) array of
 * integers. You will write two static methods, both of which are in a single
 * enclosing class named Successors (not shown). These methods process a 2D
 * integer array that contains consecutive values. Each of these integers may
 * be in any position in the 2D integer array. For example, the following 2D
 * integer array with 3 rows and 4 columns contains the integers 5 through 16.
 * <p>
 * |  0    1    2    3
 * =======================
 * 0 | 15 |  5 |  9 | 10 |
 * 1 | 12 | 16 | 11 |  6 |
 * 2 | 14 |  8 | 13 |  7 |
 */
public class Successors {
    /**
     * (a) Write a static method findPosition that takes an integer value and
     * a 2D integer array and returns the position of the integer in the given
     * 2D integer array. If the integer is not an element of the 2D integer
     * array, the mathod returns null.
     * <p>
     * For example, assume that arr is the 2D integer array shown above.
     * - The call findPosition(8, arr) would return the Position object (2, 1)
     * because the value 8 appears in arr at row 2, column 1.
     * - The call findPosition(17, arr) would return null because the value 8
     * does not appear in arr.
     * <p>
     * Precondition: intArr contains at least one row and contains consecutive values.
     */
    public static Position findPosition(int num, int[][] intArr) {
//HIDE
        for (int r = 0; r < intArr.length; r++)
            for (int c = 0; c < intArr[r].length; c++)
                if (intArr[r][c] == num + 1)
                    return new Position(r, c);
        return null;
        //EDIT return null;    // STUB
    }

    /**
     * (b) Write a static method getSuccessorArray that creates a 2D successor
     * array of positions created from a given 2D integer array.
     * <p>
     * The successor of an integer value is the integer that is one greater
     * than that value. For example, the successor of 8 is 9. A 2D successor
     * array shows the position of the successor of each element in a given
     * 2D integer array. The 2D successor array has the same dimension as the
     * given 2D integer array. Each element in the 2D successor array is the
     * position (row, column) of the corresponding 2D integer array element's
     * successor. The largest element in the 2D integer array does not have a
     * successor in the 2D integer array, so its corresponding position in the
     * 2D successor array is null.
     * <p>
     * The following diagram shows a 2D integer array and its corresponding
     * 2D successor array.
     * |  0    1    2    3        |   0       1       2       3
     * =======================    =================================
     * 0 | 15 |  5 |  9 | 10 |    0 | (1,1) | (1,3) | (0,3) | (1,2)
     * 1 | 12 | 16 | 11 |  6 |    1 | (2.2) |  null | (1,0) | (2,3)
     * 2 | 14 |  8 | 13 |  7 |    2 | (0,0) | (0,2) | (2,0) | (2,1)
     * <p>
     * Precondition: intArr contains at least one row and contains consecutive values.
     * Each of the integers may be in any position in the 2D array.
     */
    public static Position[][] getSuccessorArray(int[][] intArr) {
//HIDE
        Position[][] result = new Position[intArr.length][];
        for (int r = 0; r < intArr.length; r++) {
            result[r] = new Position[intArr[r].length];
            for (int c = 0; c < intArr[r].length; c++) {
                result[r][c] = findPosition(intArr[r][c] + 1, intArr);
            }
        }
        return result;
        //EDIT return null;    // STUB
    }
}