<!-- DESCRIPTION -->
<!-- <main style="border: thin solid gray; padding: 1em;"> -->

# <a href="http://codecheck.io/">Codecheck.io</a>

This illustrates many of the *convention over configuration* testing approaches of the *new* directory-less <a href="http://horstmann.com/codecheck/authoring.html">Codecheck.io</a>. (Note: at least *one* `.java` file must have a `public static void main(String[] args)` method.)

- `CodecheckMain` illustrates <a href="http://codecheck.io/">Codecheck.io</a>'s output-matching approach to unit tests by simply <a href="https://docs.oracle.com/javase/8/docs/api/java/io/PrintStream.html#print-java.lang.String-">`SOP`</a>ing results calculated from generated or static test data or read from a `.in` file through <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#in">`System.in`</a>.
- `CodecheckTest` is a <a href="https://junit.org/junit5/">Junit</a> test suite run automatically, because the filename ends with '`Test`' (or '`Test1`', '`Test2`', '`Test3`', &hellip;).
- `CodecheckTester` illustrates <a href="http://codecheck.io/">Codecheck.io</a>'s line pair output-matching approach to unit testing for filenames ending with '`Tester`' (or '`Tester1`', '`Tester2`', '`Tester3`', &hellip;) &mdash; every line has '`: `', every other line begins with '`Expected: `', and value pairs following '`: `' must match.
<!-- - `CodecheckUnit` provides a `<a href="https://wiki.c2.com/?PublicStaticVoidMain">PSVM</a>` method for the <a href="https://junit.org/junit5/">Junit</a> test suite. (It is not necessary, as <a href="https://junit.org/junit5/">Junit</a> `Test` classes are run automatically.) -->

To complete the assignment, complete the following methods and click *`CodeCheck`* at the bottom of the page:

1. Complete the code for the `public static int square(int n)` method in the `CodecheckSquare` class that calculates the square of `n`.
1. Complete the code for the `public static int cube(int n)` method in the `CodecheckCube` class that calculates the cube of `n`.

<!-- APCS BOILERPLATE -->

Include an initial comment with an `@author YOUR NAME <your@email.address>` line in all solution files.

<!-- /**/ EXPLANATION -->

<hr style="border-top: thin solid gray; background: none;">

**Note**: In [APCS](https://apstudents.collegeboard.org/courses/ap-computer-science-a) free-response-question [CodeCheck](http://horstmann.com/)s there may be code on lines with a `/**/` comment in the leftmost column &mdash; like this:

<pre style="margin-left: 1.5em; border-left: thin solid gray; padding-left: 0.5em;">   // There may be instance variables, constructors, and methods that are not shown.
/**/private String word;
/**/public HiddenWord(String word) { this.word = word; }
/**/public int length() { return this.word.length(); }</pre>

Any code on lines with a `/**/` comment in the leftmost column has been added by the [CodeCheck](http://horstmann.com/) author(s) and is outside the scope of the APCS free-response question. That code is necessary to complete or test the program(s) and should not be modified, but there may be other valid implementations. Consequently, your solution *cannot make assumptions about, nor make use of the knowledge of, any particular implementation of the added code*.
<!-- </main> -->