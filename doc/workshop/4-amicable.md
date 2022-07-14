# 4. Create Codecheck.io Junit tests on your own

| Step | Instructions |
| --- | --- |
| Complete a solution for `Amicable` | <ol><li>See [problem](https://psb-david-petty.github.io/2022-csta/src/4-Amicable/problem.html).</li></ol> |
| Use `Generate.java` to generate test data | <ol><li>Generate test data.</li></ol> |
| Complete `AmicableTest.java` | <ol><li>Add generated test data.</li> <li>Complete `testFindPosition()` and `testGetSuccessorArray()` unit tests.</li></ol> |

## Solution(s)

Possible missing code from `Amicable.java` is below. 

```Java
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
        //EDIT return 0;       // STUB
    }

    public static boolean areAmicable(int m, int n) {
//HIDE
        return sumProperDivisors(m) == n && sumProperDivisors(n) == m;
        //EDIT return false;   // STUB
    }
```

Possible missing code from `AmicableTest.java` is below. 

```Java
    @Test
    public void testSumProperDivisors() {
        System.out.printf("%s\n", Feedback.formatBanner("testSumProperDivisors"));
//HIDE
        for (int i = 0; i < sums.length; i++) {
            System.out.printf("sumProperDivisors(%s) == %s\n",
                i, Amicable.sumProperDivisors(i));
            Assert.assertEquals(String.format("sumProperDivisors(%s)", i),
                 sums[i], Amicable.sumProperDivisors(i));
            //EDIT // Complete test of sumProperDivisors, giving feedback.
            }
    }

    @Test
    public void testAreAmicable() {
        System.out.printf("%s\n", Feedback.formatBanner("testAreAmicable"));
//HIDE
        assert minima.length == maxima.length && maxima.length == amicable.length:
            String.format("minima (%s), maxima (%s) or amicable (%s) not the same length\n",
                minima.length, maxima.length, amicable.length);
        for (int i = 0; i < minima.length; i++) {
            System.out.printf("areAmicable(%s, %s) == %s\n",
                minima[i], maxima[i], Amicable.areAmicable(minima[i], maxima[i]), amicable[i]);
            Assert.assertEquals("areAmicable(" + minima[i] + ", " + maxima[i] + ")",
                amicable[i], Amicable.areAmicable(minima[i], maxima[i]));
            //EDIT // Complete test of areAmicable, giving feedback.
        }
    }
```

<hr>

[&#8617; back](https://psb-david-petty.github.io/2022-csta/doc/), [&#128279; permalink](https://psb-david-petty.github.io/2022-csta/doc/workshop/4-amicable.html), and [&#128297; repository](https://github.com/psb-david-petty/2022-csta/blob/main/doc/workshop/4-amicable.md) for this page.
