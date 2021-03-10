package str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    private static boolean[] used;

    public static String[] permutation(String s) {
        List<String> res = new ArrayList<String>();
        if ( s == null ) {
            return null;
        }
        used = new boolean[s.length()];
        // List<Character> path = new ArrayList<>();
        // char[] path = new char[s.length()];
        StringBuilder path = new StringBuilder();
        char[] charArray = s.toCharArray();
        Arrays.sort( charArray );
        dfs( charArray, 0, res, path);
        String[] str = new String[res.size()];
        for ( int i = 0; i < res.size(); i++ ) {
            str[i] = res.get(i);
        }
        return str;
    }

    private static void dfs( char[] charArray, int depth, List<String> res, StringBuilder path ) {
        if ( charArray.length == depth ) {
            res.add( path.toString() );
        }
        for ( int i = 0; i < charArray.length; i++ ) {
            if ( used[i] ) {
                continue;
            }
//            这个去重的前提是进行排序
            if ( i != 0 && charArray[i] == charArray[i-1] && !used[i-1] ) {
                continue;
            }
            path.append( charArray[i] );
            used[i] = true;
            dfs( charArray, depth+1, res, path);
            path.deleteCharAt( path.length()-1 );
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        String str = "aab";
        String[] strs = permutation(str);
        for ( String str1 : strs ) {
            System.out.print(" "+str1+" ");
        }
    }
}
