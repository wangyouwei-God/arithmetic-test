package str;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        int len = 'z'-'A'+1;
        int[] temp = new int[len];
        for ( int i = 0; i < s.length(); i++ ) {
            int index = s.charAt(i) - 'A';
            temp[index]++;
        }
        int ans = 0;
        for ( int i = 0; i < len; i++ ) {
            ans += temp[i] - (temp[i]&1);
        }
        return ans < s.length() ? ans+1 : ans;
    }

    public static void main(String[] args) {
        System.out.println( longestPalindrome("abccccdd"));
        StringBuilder sb = new StringBuilder();

    }
}
