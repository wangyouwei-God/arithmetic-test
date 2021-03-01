package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2( int[] candidates, int target ) {
        List<List<Integer>> res = new ArrayList<>();
        if ( candidates == null ) {
            return res;
        }
        Arrays.sort( candidates);
        List<Integer> combinations = new ArrayList<Integer>();
        recursion( candidates, 0, target, 0, combinations, res);
        return res;
    }
    private static void recursion( int[] candidates,int startIndex, int target, int sum, List<Integer> combinations, List<List<Integer>> res ) {
        if ( sum == target ) {
            res.add( new ArrayList<>(combinations));
            System.out.println("找到了组合："+combinations);
            return ;
        }
        if ( startIndex >= candidates.length ) {
            return ;
        }
        if ( sum + candidates[startIndex] <= target ) {
            System.out.print( "组合："+"  "+combinations+"  "+"添加了 ："+candidates[startIndex]+";");
            combinations.add( candidates[startIndex] );
            System.out.println("开始递归：");
            recursion( candidates, startIndex, target, sum+candidates[startIndex], combinations, res);
            combinations.remove( combinations.size() - 1 );
            System.out.println( "组合："+"  "+combinations+"  "+"移除了 ："+candidates[startIndex]+";");
        }
        System.out.println("组合："+"  "+combinations+"  "+"开始跳过："+candidates[startIndex]+"开始执行下一项递归");
        recursion( candidates, startIndex+1, target, sum, combinations, res);
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 6, 7};
        System.out.println( combinationSum2( nums, 7) );
    }
}
