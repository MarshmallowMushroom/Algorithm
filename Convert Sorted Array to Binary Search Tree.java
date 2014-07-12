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
    public TreeNode sortedArrayToBST(int[] num) {
        return ArrayToBST(num, 0, num.length - 1);
    }
    
    public TreeNode ArrayToBST(int[] num, int start, int end) {
        if (start > end)
            return null;
        if (start == end)
            return new TreeNode(num[start]);
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(num[mid]);
        TreeNode left = ArrayToBST(num, start, mid - 1);
        TreeNode right = ArrayToBST(num, mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
