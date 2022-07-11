# 1. Introduction to Junit

Let's work on this together!

| Step | Instructions |
| --- | --- |
| Complete a [Codecheck.io](Codecheck.io) | Complete [https://codecheck.io/files/22071124088wj28phd2wb49lg83v4ztq8qe](https://codecheck.io/files/22071124088wj28phd2wb49lg83v4ztq8qe) |
| Generate a codecheck.zip | |
| Create your own [Codecheck.io](Codecheck.io) | |

## Solution

The missing code from `CodecheckTest.java` is below. 

```Java
    @Test
    public void testSquares() {
        System.out.printf("%s\n", Feedback.formatBanner("testSquares"));
        for (int i = 0; i < squares.length; i++) {
            int n = squares[i][0], nSquared = squares[i][1];
            System.out.printf("square(%s) \u2192 %s\n",
                n, CodecheckSquare.square(n));
            Assert.assertEquals(String.format("square(%s)", n),
                 nSquared, CodecheckSquare.square(n));
            }
    }

    @Test
    public void testCubes() {
        System.out.printf("%s\n", Feedback.formatBanner("testCubes"));
        for (int i = 0; i < cubes.length; i++) {
            int n = cubes[i][0], nCubed = cubes[i][1];
            System.out.printf("cube(%s) \u2192 %s\n",
                n, CodecheckCube.cube(n));
            Assert.assertEquals(String.format("cube(%s)", n),
                nCubed, CodecheckCube.cube(n));
            }
    }
```

<hr>

[&#8617; back](https://psb-david-petty.github.io/2022-csta/doc/), [&#128279; permalink](https://psb-david-petty.github.io/2022-csta/doc/workshop/1-codecheck.html), and [&#128297; repository](https://github.com/psb-david-petty/2022-csta/blob/main/doc/workshop/1-codecheck.md) for this page.
