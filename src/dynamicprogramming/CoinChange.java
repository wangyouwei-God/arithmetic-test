package dynamicprogramming;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if ( coins == null || coins.length == 0 ) {
            return -1;
        }
        int res = helper( coins, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private static int helper( int[] coins, int amount ) {
        if ( amount == 0 ) {
            return 0;
        }
        int minSum = Integer.MAX_VALUE;
        for ( int i=0; i<coins.length; i++ ) {
            if ( amount >= coins[i] ) {
                int preSum = helper( coins, amount-coins[i]);
                if ( preSum < Integer.MAX_VALUE ) {
                    minSum = Math.min(minSum, preSum + 1);
                }
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5};
        System.out.println( coinChange( nums, 20) );
    }
}
