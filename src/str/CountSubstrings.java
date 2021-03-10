package str;

public class CountSubstrings {
    public static int countSubstrings( String s ) {
        if ( s == null ) {
            return -1;
        }
        int len = s.length();
        int resSum = 0;
        for ( int right = 0; right < len; right++ ) {
            boolean remDp = false;
            for ( int left = right; left >= 0; left-- ) {
                if ( s.charAt(left) == s.charAt(right) && right-left<=2 ) {
                    remDp = true;
                    resSum++;
                } else if ( s.charAt(left) == s.charAt(right) && remDp ){
                    remDp = true;
                    resSum++;
                } else {
                    remDp = false;
                }
            }
        }
        return resSum;
    }

    public static void main(String[] args) {
        System.out.println( countSubstrings("abc" ) );
    }
}
