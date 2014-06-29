/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        List<Integer> result = new ArrayList<Integer>();
        result.add(root.val);
        if (!left.isEmpty())
            result.addAll(left);
        if (!right.isEmpty())
            result.addAll(right);
        return result;
    }
}
