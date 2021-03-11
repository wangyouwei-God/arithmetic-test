package dynamicprogramming;

public class MinDistance {
    public static int minDistance(String word1, String word2) {
//        当字符串为0的时候，也就是没有字符的时候，如何生成另一个字符串呢，
//        当然，就是要添加那么多个字符，如果另一个字符串的数量为10，那么就需要添加10个字符，需要的操作数为10
//        当自己有n个字符，对方却是零个字符时，要想实现转换，需要的操作步骤，就是把自己的n个字符全部删除，需要
//        的操作步骤为n。
//        又因为字符串可以为空，那么就用dp[0][j]来生成，而直接生成dp[word1.length()][word2.length()]这
//        样大小的数组，是没法表示有一方字符串为空的情况的，所以为了表示出有一方的字符串为空，就要将动态记忆数组的
//        大小进行加1，让dp[i][j]表示索引为word1[i-1]和word2[j-1]的字符串位置上的情况，记录对应位置及之前
//        最少需要多少次的操作，才能变化成对应的操作。
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for ( int i = 0; i < word1.length()+1; i++ ) {
            for ( int j = 0; j < word2.length()+1; j++ ) {
                if ( i == 0 || j == 0 ) {
                    dp[i][j] = Math.max(i,j);
                } else {
                    if ( word1.charAt(i-1) == word2.charAt(j-1) ) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.min( Math.min( dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                    }
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int n = minDistance( word1, word2);
        System.out.println(n);
    }
}
