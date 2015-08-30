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
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int hl = 0;
        TreeNode l = root;
        while(l != null) {
            l = l.left;
            hl++;
        }
        int hr = 0;
        TreeNode r = root;
        while(r != null) {
            r = r.right;
            hr++;
        }
        if (hl == hr)
            return (2<<(hl-1))-1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
