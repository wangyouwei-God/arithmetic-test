package str;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstUniqueChar {
    public static char firstUniqChar(String s) {
        if ( s == null ) {
            return ' ';
        }
        Map<Character,Integer> map = new LinkedHashMap<>();
        for ( int i = 0; i < s.length(); i++ ) {
            if ( !map.containsKey(s.charAt(i)) ) {
                map.put( s.charAt(i), 1);
            } else {
                int count = map.get( s.charAt(i) );
                map.put( s.charAt(i), count+1);
            }
        }
        Set<Character> set = map.keySet();
        for ( Character c : set ) {
            if ( map.get(c) == 1 ) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println( firstUniqChar(str) );
    }
}
