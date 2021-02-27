package dynamicprogramming;

/**
 * @author wangyouwei
 */
public class CanJump {
    public static boolean canJump(int[] nums) {
        long initialMemory = Runtime.getRuntime().totalMemory();
        System.out.println( initialMemory );
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println( maxMemory );
        int[] heap = new int[100240*100240];
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for ( int i=1; i<n; i++ ) {
            dp[i] = false;
            for ( int j=0; j<i; j++ ) {
                if ( dp[j] == true && j+nums[j] >= i ) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n-1];
    }
    public static boolean canJumpByGreed( int[] nums ) {
        int n = nums.length;
        // 贪心算法
        int maxReach = 0;
//        i为当前能到达的距离，你一直遍历数组，肯定就做不对呀
        for ( int i=0; i<maxReach; i++) {
            maxReach = Math.max( maxReach, i+nums[i]);
            if ( maxReach >= n-1 ) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        canJumpByGreed( nums);
        canJump( nums );
    }
}
