package dynamicprogramming;

public class UniquePathsWithObstacles {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if ( obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 ) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        if ( obstacleGrid[0][0] == 1 ) {
            dp[0][0] = 0;
            return 0;
        }
        dp[0][0] = 1;
        for ( int i = 1; i < obstacleGrid.length; i++ ) {
            if ( obstacleGrid[i][0] == 1 ) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i-1][0];
            }
        }
        for ( int j = 1; j < obstacleGrid[0].length; j++ ) {
            if ( obstacleGrid[0][j] == 1 ) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = dp[0][j-1];
            }
        }
        for ( int i = 1; i < obstacleGrid.length; i++ ) {
            for ( int j = 1; j < obstacleGrid[0].length; j++ ) {
                if ( obstacleGrid[i][j] == 1 ) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0}};
        System.out.println( uniquePathsWithObstacles( obstacleGrid ) );
    }
}
