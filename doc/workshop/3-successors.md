# 3. Create a Codecheck.io using arrays (APCS-A FRQ)

This is an example from a [2017 APCS-A free response question](https://secure-media.collegeboard.org/ap/pdf/ap-computer-science-a-frq-2017.pdf)

| Step | Instructions |
| --- | --- |
| Complete a solution for `Successors.java` | <ol><li>Implement both methods in `Successors.java` from [2017 APCS-A A4](https://secure-media.collegeboard.org/ap/pdf/ap-computer-science-a-frq-2017.pdf) (see [problem](https://psb-david-petty.github.io/2022-csta/src/3-Successors/problem.html)). |
| Complete `Generate.java` to generate test data | <ol><li>Generate position test data. |
| Complete `SuccessorsTest.java` | <ol><li>Add generated test data. <li>Complete `testFindPosition()` and `testGetSuccessorArray()` unit tests. |

## Solution(s)

Possible missing code from `Successors.java` is below. 

```Java
    public static Position findPosition(int num, int[][] intArr) {
//HIDE
        for (int r = 0; r < intArr.length; r++)
            for (int c = 0; c < intArr[r].length; c++)
                if (intArr[r][c] == num + 1)
                    return new Position(r, c);
        return null;
        //EDIT return null;    // STUB
    }

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
```

Possible missing code from `Generate.java` is below. 

```Java
//HIDE
            List<Position> ps = new ArrayList<Position>();
            pls.add(ps);
            int start = ras[i][0], end = ras[i][1];
            for (int j = start; j < end; j++)
                ps.add(Successors.findPosition(j, ias[i]));
            //EDIT use findPosition to generate test data for all ias range values
```

Possible missing code from `SuccessorsTest.java` is below. 

```Java
    @Test
    public void testFindPosition() {
        System.out.printf("%s\n", Feedback.formatBanner("testFindPosition"));
        assert ias.length == ras.length && ras.length == pas.length
            : "ias.length != ras.length || ras.length != pas.length";
        for (int i = 0; i < ias.length; i++) {
//HIDE
            int start = ras[i][0], end = ras[i][1];
            for (int j = 0; j < pas[i].length; j++) {
                Position ap = Successors.findPosition(j + start, ias[i]);
                System.out.printf("%s[%s] = %s\n",
                    Arrays.deepToString(ias[i]), j + start, ap);
            Assert.assertEquals(pas[i][j].toString() + " != " + ap,
                pas[i][j], ap);
            //EDIT // Give feedback on findPosition and use method from Assert to test.
            }
        }
    }

    @Test
    public void testGetSuccessorArray() {
        System.out.printf("%s\n", Feedback.formatBanner("testSetSuccessorArray"));
        assert ias.length == sas.length : "ias.length != sas.length";
        for (int i = 0; i < ias.length; i++) {
//HIDE
            Position[][] aa = Successors.getSuccessorArray(ias[i]);
            Position[][] ea = sas[i];
            System.out.printf("%s -> %s\n",
                Feedback.format2Dint(ias[i]), Feedback.format2DObject(aa));
            Assert.assertArrayEquals(Arrays.deepToString(ea)
                + " != " + Arrays.deepToString(aa),
                aa, ea);
            //EDIT // Give feedback on getSuccessorArray and use method from Assert to test.
        }
    }
```

<hr>

[&#8617; back](https://psb-david-petty.github.io/2022-csta/doc/), [&#128279; permalink](https://psb-david-petty.github.io/2022-csta/doc/workshop/3-successors.html), and [&#128297; repository](https://github.com/psb-david-petty/2022-csta/blob/main/doc/workshop/3-successors.md) for this page.
