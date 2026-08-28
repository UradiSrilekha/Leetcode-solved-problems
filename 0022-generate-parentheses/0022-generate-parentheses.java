import java.util.*;

class Solution {
    public void backtrack(String curr, int open, int close, int n, List<String> res) {
        if (curr.length() == 2 * n) {
            res.add(curr);
    
        }
        if (open < n) backtrack(curr + "(", open + 1, close, n, res);
        if (close < open) backtrack(curr + ")", open, close + 1, n, res);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack("", 0, 0, n, res);
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
Solution sol = new Solution();
        List<String> result = sol.generateParenthesis(3);
        for (String s : result) {
            System.out.println(s);
        }
    }
}