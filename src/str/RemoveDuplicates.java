package str;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicates {
    public static String removeDuplicates(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        int len = S.length();
//        借助双端队列实现栈的思路来做
//        Deque<Character> stack = new ArrayDeque<>();
//        for (int i = 0; i < len; i++) {
//            if (!stack.isEmpty() && S.charAt(i) == stack.peekLast()) {
//                stack.removeLast();
//            } else {
//                stack.addLast(S.charAt(i));
//            }
//        }
//        char[] charArray = new char[stack.size()];
//        int i = 0;
//        while ( !stack.isEmpty() ) {
//            charArray[i++] = stack.removeFirst();
//        }
//        return new String(charArray, 0, charArray.length);
        StringBuilder sb = new StringBuilder(S.length());
        for ( int i = 0; i < S.length(); i++ ) {
            if ( sb.length() != 0 && sb.charAt(sb.length()-1) == S.charAt(i) ) {
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println( removeDuplicates("abbaca" ) );
    }
}
