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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return checkSymmetric(root.left, root.right);
    }
    
    private boolean checkSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val == root2.val)
            return checkSymmetric(root1.left, root2.right) && checkSymmetric(root2.left, root1.right);
        return false;
    }   
}
