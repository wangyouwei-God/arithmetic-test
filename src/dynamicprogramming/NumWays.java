package dynamicprogramming;

public class NumWays {
    private static int[] rem;
    public static int numWays( int n ) {
        if ( n < 2 ) {
            return 1;
        }
        rem = new int[n+1];
        rem[0] = 1;
        rem[1] = 1;
        rem[2] = 1;
        return helper( n);
}
    private static int helper( int n ) {
        if ( rem[n] != 0 ) {
            return rem[n];
        }
        rem[n] = ( helper(n-1)+helper(n-2) )%1000000007;
        return rem[n];
    }

    public static void main(String[] args) {
        System.out.println( numWays(2) );
    }
}
