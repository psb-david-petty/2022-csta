/*
 * Amicable.java
 * 
 * Two integers m and n are called amicable if the sum of proper divisors of m 
 * is equal to n and the sum of proper divisors of n is equal to m. For example,
 * 220 and 284 form a pair of amicable numbers: 
 * 1 + 2 + 4 + 5 + 10 + 11 + 20 + 22 + 44 + 55 + 110 = 284; 
 * 1 + 2 + 4 + 71 + 142 = 220.
 * 
 * (a) Write a method sumProperDivisors that calculates the sum of all proper 
 * divisors of a positive integer. (Proper divisors of a positive integer are 
 * positive integers less than the integer that divide it without remainder.)
 * (b) Write a method public boolean areAmicable(int m, int n) that returns true 
 * if m and n are amicable, otherwise false.
 *
//HIDE
 * @author David C. Petty // http://j.mp/psb_david_petty
 //EDIT * @author YOUR NAME <your@email.address>
 */
//ID Amicable
class Amicable
{
    public static int sumProperDivisors(int n) {
//HIDE
        int sum = 0, i;             // must be able to test last value of i
        for (i = 1; i * i < n; i++) // look for divisors up to square root of n
            if (n % i == 0)
            sum += i + n / i;       // add both divisors
        // if n is a perfect square, add i
        if (i * i == n)
            sum += i;
        return sum - n;             // because n / 1 was added
    }

    public static int sumProperDivisorsNaive(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++)
            if (n % i == 0)
                sum += i;
        return sum;
        //EDIT return 0;       // STUB
    }

    public static boolean areAmicable(int m, int n) {
//HIDE
        return sumProperDivisors(m) == n && sumProperDivisors(n) == m;
        //EDIT return false;   // STUB
    }
}