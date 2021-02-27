package dynamicprogramming;

/**
 * @author wangyouwei
 */
public class MyAtoi {
    public static int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        if ( s == null && s.length() == 0 ) {
            return 0;
        }
        int i = 0;
        while ( i < s.length() && s.charAt(i) == ' ' ) {
            i++;
        }
        if ( i < s.length() && s.charAt(i) == '-' ) {
            flag = false;
            i++;
        } else if ( i < s.length() && s.charAt(i) == '+' ) {
            i++;
        }
        while ( i < s.length() && Character.isDigit( s.charAt(i) )) {
            sb.append( s.charAt(i) );
            i++;
        }
        i = 0;
        int sum = 0;
        while ( i < sb.length() ) {
            int tem = sb.charAt(i) - '0';
            if ( flag && (sum > Integer.MAX_VALUE/10 || (sum == Integer.MAX_VALUE/10 && tem >= 7))) {
                return Integer.MAX_VALUE;
            } else if ( !flag && ( sum > Integer.MAX_VALUE/10 || ( sum == Integer.MAX_VALUE/10 && tem >= 8))){
                return Integer.MIN_VALUE;
            } else {
                sum = sum*10 + tem;
                i++;
            }
        }
        if ( !flag ) {
            return -sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "-2147483649";
        System.out.println( myAtoi(s) );
    }

}
