package str;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                list.add(c);
            } else if ( i != s.length()-1 ){
                list.clear();
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        String str = "a";
        lengthOfLastWord(str);
        Stack<Integer> stack = new Stack<Integer>();
//        System.out.println( stack.pop() );
//        System.out.println( stack.peek() );
    }
}
