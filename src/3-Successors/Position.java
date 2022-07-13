/*
 * Position.java
 *
 * @author David C. Petty // http://j.mp/psb_david_petty
 */

/**
 * The following Position class is used to represent positions in the integer
 * array. The notation (r, c) will be used to refer to a Position object with
 * row r and column c.
 */
public class Position
{
    /** Constructs a Position object with row r and column c. */
    public Position(int r, int c) {
        /* Implementation not shown */
        this.r = r; this.c = c;
    }
    // There may be instance variables, constructors, and methods that are not shown.
/**/private int r, c;
/**/@Override public boolean equals(Object that)
/**/{   if (that == null) return false;
/**/    Position pThis = (Position)this, pThat = (Position)that;
/**/    return pThis.r == pThat.r && pThis.c == pThat.c; }
/**/public String toString() { return "(" + r + "," + c + ")"; }
/**/public String repr() { return "new Position" + toString(); }
}