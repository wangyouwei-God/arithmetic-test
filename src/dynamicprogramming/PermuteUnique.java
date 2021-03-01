package dynamicprogramming;

import java.util.*;

public class PermuteUnique {
        private boolean[] used;
        public List<List<Integer>> permuteUnique(int[] nums) {
                List<List<Integer>> res = new LinkedList<>();
                if ( nums == null ) {
                        return res;
                }
                List<Integer> path = new ArrayList<Integer>();
                used = new boolean[nums.length];
                Arrays.sort( nums );
                helper( nums, 0, path, res);
                return res;
        }
        private void helper( int[] nums, int depth, List<Integer> path, List<List<Integer>> res ) {
                if ( depth == nums.length ) {
                        res.add( new ArrayList<>(path) );
                        return ;
                }
                for ( int i=0; i<nums.length; i++ ) {
                        if ( used[i] ) {
                                continue;
                        }
                        if( i != 0 && nums[i] == nums[i-1] && !used[i-1] ) {
                                continue;
                        }
                        path.add( nums[i] );
                        used[i] = true;
                        helper( nums, depth+1, path, res);
                        path.remove( path.size()-1 );
                        used[i] = false;
                }
        }
}