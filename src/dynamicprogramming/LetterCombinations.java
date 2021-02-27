package dynamicprogramming;

import java.util.*;

public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
// 使用队列的方法
        List<String> res = new ArrayList<String>();
        if ( digits == null || digits.length() == 0 ) {
            return res;
        }
        Queue<String> queue = new LinkedList<String>();
        Map<Character,String> map = new HashMap<Character,String>();
        map.put( '2', "abc");
        map.put( '3', "def");
        map.put( '4', "ghi");
        map.put( '5', "jkl");
        map.put( '6', "mno");
        map.put( '7', "pqrs");
        map.put( '8', "tuv");
        map.put( '9', "wxyz");
        for ( int i=0; i<digits.length(); i++) {
            String ans = map.get( digits.charAt(i) );
            helper( queue, ans);
        }
        for ( String str : queue ) {
            res.add( str );
        }
        return res;
    }
    private static void helper(Queue<String> queue, String ans ) {
        if ( queue.isEmpty() ) {
            for ( int i=0; i<ans.length(); i++) {
                queue.add( String.valueOf( ans.charAt(i) ) );
            }
            return ;
        }
        int size = queue.size();
        for ( int i=0; i<size; i++ ) {
            String str = queue.poll();
            for ( int j=0; j<ans.length(); j++) {
                queue.add( str + ans.charAt(j) );
            }
        }
    }

    public static void main(String[] args) {
        String str = "23";
        System.out.println( letterCombinations( str) );
    }
}
