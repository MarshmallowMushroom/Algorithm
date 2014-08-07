/*
algorithm is simple, use the call stack to create a tree structured excution to generate all the leaf nodes and record them in to the result
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        tryParenthesis(result, "", n, 0);
        return result;
    }
    
    List<String> result;
    private void tryParenthesis(List<String> result, String p, int left, int right) {
        if (left == 0 && right == 0) {//all the parenthesis are used, write to result
            result.add(p);
            return;
        }
        if (left != 0) {
            String next = new String(p + "(");
            tryParenthesis(result, next, left - 1, right + 1);
        }
        if (right != 0) {
            String next = new String(p + ")");
            tryParenthesis(result, next, left, right - 1);
        }
    }
}
