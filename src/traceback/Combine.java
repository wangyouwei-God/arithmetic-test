package traceback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if ( k == 0 ) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        helper( n, 1, k, path, res );
        return res;
    }
    private void helper( int n, int index, int depth, List<Integer> path, List<List<Integer>> res ) {
        if ( depth == 0 ) {
            res.add( new ArrayList<>(path));
            return ;
        }
        for ( int i = index; i <= n; i++ ) {
            path.add( index );
            helper( n, index+1, depth-1, path, res );
            path.remove( path.size() - 1 );
        }
    }
}
