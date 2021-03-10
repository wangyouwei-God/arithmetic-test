package traceback;

import java.util.Arrays;

public class CutPartition {
    public static int minCut( String s ) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        boolean[][] rem = new boolean[s.length()][s.length()];
        for (int right = 0; right < rem.length; right++) {
            for (int left = right; left >= 0; left--) {
                if (left == right) {
                    rem[left][right] = true;
                } else if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || rem[left + 1][right - 1])) {
                    rem[left][right] = true;
                }
            }
        }
        int[] dp = new int[s.length()];
//        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            if (rem[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i-1] + 1;
                for (int j = 1; j < i; j++) {
                    if (rem[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j-1] + 1);
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        String str = "cdd";
        System.out.println( minCut(str) );
    }
}
