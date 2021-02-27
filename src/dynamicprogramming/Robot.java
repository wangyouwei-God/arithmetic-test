package dynamicprogramming;

/**
 * 动态规划四步：
 *  1、确定状态是啥，即数组里面记录啥
 *  2、确定子问题是啥
 *  3、怎么由前面的子结构，求出最后一步
 *  4、写出状态转移方程
 *  5、初始化条件和边界
 *  6、顺序求解。
 * @author wangyouwei
 * 1、确定状态，确定问题的最后一步，后子问题
 * 	2、转移方程，写出状态转移方程，就是怎么求出最后一步，转化为数学语言
 * 	3、初始条件和边界情况，初始条件就是用转移方程算不出来，但是后续的计算，又需要这些状态，需要手工定义的
 * 	4、计算顺序
 */
public class Robot {
    public static int solution( int[][] nums ) {
//        记录状态，用数组记忆
        int[][] dp = new int[nums.length][nums[0].length];
//        dp[0] 这一系列是无法用 状态方程求出来的，所以就进行初始化，
        for ( int i=0; i<nums.length; i++) {
            dp[i][0] = 1;
        }
        for ( int j=0; j<nums[0].length; j++) {
            dp[0][j] = 1;
        }
//        顺序计算
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
