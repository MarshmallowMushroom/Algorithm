/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
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
    int total; 
    public int maxPathSum(TreeNode root) {
        total = Integer.MIN_VALUE;
        getMax(root);
        return total;
    }
    
    public int getMax(TreeNode root) {
        if (root.left == null && root.right == null) {
            total = Math.max(total, root.val);
            return root.val;
        }
        int left = 0;
        int right = 0;
        if (root.left != null)
            left = Math.max(getMax(root.left), left);
        if (root.right != null)
            right = Math.max(getMax(root.right), right);
        //compare total with the max number in the current subtree.
        int max = root.val;
        max = left > 0? max + left : max;
        max = right > 0? max + right : max;
        total = Math.max(total, max);
        //return the left or right subtree max to upper level
        int maxSub = root.val;
        maxSub = Math.max(maxSub, maxSub + Math.max(left, right));
        return maxSub;
    }
}
