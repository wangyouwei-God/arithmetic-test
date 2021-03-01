package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if ( candidates == null ) {
            return res;
        }
        Arrays.sort( candidates);
        List<Integer> combination = new ArrayList<Integer>();
        helper( candidates, res, combination, target, 0, 0);
        return res;
    }

    private void helper( int[] candidates,
                         List<List<Integer>> res,
                         List<Integer> combination,
                         int target,
                         int sum,
                         int dex) {
        if ( sum == target ) {
            res.add( new ArrayList<>(combination));
            return ;
        }
        for( int i = dex; i < candidates.length; i++ ) {
             if ( candidates[i]+sum < target ) {
                combination.add( candidates[i] );
                helper( candidates, res, combination, target, sum + candidates[i], i);
                combination.remove( combination.size()-1);
             }
        }
    }
}
