/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();
        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);
        List<Integer> result = new ArrayList<Integer>();
        if (!left.isEmpty())
            result.addAll(left);
        if (!right.isEmpty())
            result.addAll(right);
        result.add(root.val);
        return result;
    }
}
