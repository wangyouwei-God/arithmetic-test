package traceback;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if ( n <= 0 ) {
            return res;
        }
        StringBuilder status = new StringBuilder();
        dfs( n, 0, 0, status, res);
        return res;
    }

    private void dfs( int n, int left, int right, StringBuilder str, List<String> res ) {
        if ( left == n && right == n ) {
            res.add( str.toString() );
            return;
        }
        // 剪枝操作
        // 如果左括号使用的数量小于右括号的数量，那么肯定就是错的啦
        // 如果左括号使用的数量等于或者大于下面的值，那么就继续的进行添加，还可以添加
        if ( left < right ) {
            return;
        }
        if ( left < n ) {
            dfs( n, left+1, right, str.append("("), res);
        }
        if ( right < n ) {
            dfs( n, left, right+1, str.append(")"), res);
        }
    }
}
