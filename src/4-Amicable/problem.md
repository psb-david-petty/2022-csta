<!-- DESCRIPTION -->
<!-- <main style="border: thin solid gray; padding: 1em;"> -->

<!-- 
    // From https://www.ams.org/journals/mcom/1967-21-098/S0025-5718-1967-0222006-7/S0025-5718-1967-0222006-7.pdf (1966)
    // https://oeis.org/A063990 (2001)
    // https://www.numbersaplenty.com/set/amicable_number/more.php (2013)
    // Amicable number pairs and expected value for isAmicable.
    private static final int[] m = { 220, 1184, 2620, 5020, 6232, 10744, 12285, 17296, 63020, 66928, 67095, 69615, 79750, 100485, 122265, 122368, 141664, 142310, 171856, 176272, 185368, 196724, 280540, 308620, 319550, 356408, 437456, 469028, 503056, 522405, 600392, 609928, 624184, 635624, 643336, 667964, 726104, 802725, 879712, 898216, 947835, 998104,
        6, 28, 496, 8128, 33550336, 10000, };
    private static final int[] n = { 284, 1210, 2924, 5564, 6368, 10856, 14595, 18416, 76084, 66992, 71145, 87633, 88730, 124155, 139815, 123152, 153176, 168730, 176336, 180848, 203432, 202444, 365084, 389924, 430402, 399592, 455344, 486178, 514736, 525915, 669688, 686072, 691256, 712216, 652664, 783556, 796696, 863835, 901424, 980984, 1125765, 1043096,
        6, 28, 496, 8128, 33550336, 10000, };
    private static boolean[] b = { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true,
        true, true, true, true, true, false, };
-->
# Amicable Numbers

Two integers <em>m</em> and <em>n</em> are called <a href="https://oeis.org/A063990">amicable</a> if the sum of proper divisors of <em>m</em> is equal to <em>n</em> and the sum of proper divisors of <em>n</em> is equal to <em>m</em>. For example, 220 and 284 form a pair of amicable numbers: 1 + 2 + 4 + 5 + 10 + 11 + 20 + 22 + 44 + 55 + 110 = 284; 1 + 2 + 4 + 71 + 142 = 220.</p>

1. Write a method <code>public int sumProperDivisors(int n)</code> that calculates the sum of all proper divisors of a positive integer <em>n</em>. (Proper divisors of a positive integer are positive numbers less than the integer that divide it without remainder.)
1. Write a method <code>public boolean areAmicable(int m, int n)</code> that returns <code>true</code> if <em>m</em> and <em>n</em> are amicable, otherwise <code>false</code>.

(Adapted from <a href="http://www.skylit.com/javamethods2/">Java Methods</a>, Chapter 8. Thanks <a href="http://www.skylit.com/">Maria & Gary</a>!)

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