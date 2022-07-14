# 1. Introduction to Unit testing with Codecheck.io and Junit

Let's work on this together!

| Step | Instructions |
| --- | --- |
| Complete a [Codecheck.io](Codecheck.io) | <ol><li>Complete [https://codecheck.io/files/22071124088wj28phd2wb49lg83v4ztq8qe](https://codecheck.io/files/22071124088wj28phd2wb49lg83v4ztq8qe) <li>Download and examine `codecheck.signed.zip`. |
| Generate a `codecheck.zip` | <ol><li>Using `codecheck.sh` or `codecheck.bat`, create a `codecheck.zip` file. |
| Create your own [Codecheck.io](Codecheck.io) |<ol><li>Follow the instructions on [Codecheck.io](Codecheck.io) to the upload [link](https://codecheck.io/assets/uploadProblem.html) and upload `codecheck.zip`. |

## Documentation

- [https://junit.org/junit4/javadoc/latest/](https://junit.org/junit4/javadoc/latest/) is the [Junit 4](https://junit.org/junit4/) Javadoc documentation. The [`Assert`](https://junit.org/junit4/javadoc/latest/org/junit/Assert.html) class is where most of the testing happens.
- [https://horstmann.com/codecheck/authoring.html](https://horstmann.com/codecheck/authoring.html) is the [Codecheck.io](Codecheck.io) documentation. Two important references are [summary of file conventions](https://github.github.com/gfm/) and [glossary of pseudocomments](https://horstmann.com/codecheck/authoring.html#glossary-of-pseudocomments).

## [Codecheck.io](Codecheck.io) Files

The files in the directory are as follows (not all files are included in `codecheck.zip`):


| File | Instructions |
| --- | --- |
| `CodecheckCube.java` | Java source file (see [problem](https://psb-david-petty.github.io/2022-csta/src/1-Codecheck/problem.html)). |
| `CodecheckMain.java` | Java source file (see [problem](https://psb-david-petty.github.io/2022-csta/src/1-Codecheck/problem.html)). |
| `CodecheckSquare.java` | Java source file (see [problem](https://psb-david-petty.github.io/2022-csta/src/1-Codecheck/problem.html)). |
| `CodecheckTest.java` | Java source file (see [problem](https://psb-david-petty.github.io/2022-csta/src/1-Codecheck/problem.html)). |
| `CodecheckTester.java` | Java source file (see [problem](https://psb-david-petty.github.io/2022-csta/src/1-Codecheck/problem.html)). |
| `CodecheckUnit.java` | Java source file (see [problem](https://psb-david-petty.github.io/2022-csta/src/1-Codecheck/problem.html)). |
| `Feedback.java` | Java source file to format unit test feedback. |
| `Format.java` | Java source file to format generated unit-test data. |
| `Generate.java` | A Java source file that generates unit-test data. |
| `codecheck.bat` | Script to create `codecheck.zip`. |
| `codecheck.sh` | Script to create `codecheck.zip`. |
| `codecheck.zip` | File created by `codecheck.bat` or `codecheck.sh` scritps. |
| `problem.html` | HTML version of problem statement. Is included in `codecheck.zip`. |
| `problem.md` | [GFM](https://github.github.com/gfm/) version of problem statement used to generate HTML version (also included to work with [`repl.it`](http://repl.it/). |
| `test.in` | Text file with program input (see [problem](https://psb-david-petty.github.io/2022-csta/src/1-Codecheck/problem.html)). |
| `zipfiles.txt` | Test file that contains names of all files to include in `coecheck.zip`. |

    
## Solution

Possible missing code from `CodecheckTest.java` is below. 

```Java
    @Test
    public void testSquares() {
        System.out.printf("%s\n", Feedback.formatBanner("testSquares"));
        for (int i = 0; i < squares.length; i++) {
            int n = squares[i][0], nSquared = squares[i][1];
            System.out.printf("square(%s) \u2192 %s\n",
                n, CodecheckSquare.square(n));
//HIDE
            Assert.assertEquals(String.format("square(%s)", n),
                 nSquared, CodecheckSquare.square(n));
            //EDIT // Use a method from the Assert class to perform the test.
            }
    }

    @Test
    public void testCubes() {
        System.out.printf("%s\n", Feedback.formatBanner("testCubes"));
        for (int i = 0; i < cubes.length; i++) {
            int n = cubes[i][0], nCubed = cubes[i][1];
            System.out.printf("cube(%s) \u2192 %s\n",
                n, CodecheckCube.cube(n));
//HIDE
            Assert.assertEquals(String.format("cube(%s)", n),
                nCubed, CodecheckCube.cube(n));
            //EDIT // Use a method from the Assert class to perform the test.
        }
    }
```

(Solutions to `CodecheckCube.java` and `CodecheckSquare.java` are not provided!)

<hr>

[&#8617; back](https://psb-david-petty.github.io/2022-csta/doc/), [&#128279; permalink](https://psb-david-petty.github.io/2022-csta/doc/workshop/1-codecheck.html), and [&#128297; repository](https://github.com/psb-david-petty/2022-csta/blob/main/doc/workshop/1-codecheck.md) for this page.
