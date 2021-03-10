package str;

public class ReverseLeftWords {
    public static String reverseLeftWords(String s, int n) {
        if ( s == null || s.length() < n ) {
            return s;
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder(len);
        for ( int i = n; i < len+n; i++ ) {
            char temp = s.charAt(i%len);
            sb.append(temp);
        }
        return sb.toString();
        // 要知道setCharAt()是替换字符串的方法，如果StringBuilder上面原来没有字符，那么就会报错。
        // 字符串拼接方法
        // return s.substring( n, s.length()) + s.substring( 0, n);
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println( reverseLeftWords(str,2));

    }
}
