/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return kth(root, k);
    }
    
    public Integer kth(TreeNode root, int k) {
        if (root == null)
            return null;
        Integer res = kth(root.left, k);
        if (res != null)
            return res;
        count++;
        if (count == k)
            return root.val;
        res = kth(root.right, k);
            return res;
    }
}
