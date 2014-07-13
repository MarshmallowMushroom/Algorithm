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
    TreeNode err1;
    TreeNode err2;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        err1 = null;
        err2 = null;
        prev = null;
        inorderTraversal(root);
        int tmp = err2.val;
        err2.val = err1.val;
        err1.val = tmp;
    }
    
    
    private void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        if (prev == null)
            prev = root;
        else {
            if (prev.val > root.val) {//mistake found
                if (err2 == null) {
                    err1 = prev;
                    err2 = root;
                }
                else {
                    err2 = root;
                }
            }
            prev = root;
        }
        inorderTraversal(root.right);
    }
}
