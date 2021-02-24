package dynamicprogramming;

/**
 * @author wangyouwei
 */
public class Robot {
    public static int solution( int[][] nums ) {
        int[][] dp = new int[nums.length][nums[0].length];
        for ( int i=0; i<nums.length; i++) {
            dp[i][0] = 1;
        }
        for ( int j=0; j<nums[0].length; j++) {
            dp[0][j] = 1;
        }
        for ( int i=1; i < nums.length; i++) {
            for ( int j=1; j < nums.length; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[nums.length-1][nums[0].length-1];
    }

    public static void main(String[] args) {
        
    }
}
