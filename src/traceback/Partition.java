package traceback;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Partition {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if ( s == null || s.length() == 0 ) {
            return res;
        }
        char[] charArray = s.toCharArray();
        Stack<String> path = new Stack<>();
        dfs( charArray, 0, path, res);
        return res;
    }

    private static void dfs( char[] charArray, int index, Stack<String> path, List<List<String>> res ) {
        if ( index == charArray.length ) {
            res.add( new ArrayList<>(path) );
            return ;
        }
        for ( int i = index; i < charArray.length; i++ ) {
            if ( ! isPalindorme( charArray, index, i) ) {
                continue;
            }
            path.push( new String( charArray, index, i-index+1 ));
            dfs( charArray, i+1, path, res);
            path.pop();
        }
    }

    private static boolean isPalindorme( char[] charArray, int left, int right ) {
        while ( left < right ) {
            if ( charArray[left] == charArray[right] ) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aabb";
        partition(str);
    }
}