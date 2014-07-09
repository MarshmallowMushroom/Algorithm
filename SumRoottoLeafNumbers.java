/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        if (root == null)
            return sum;
        genSum(root, sum);
        return sum;
    }
    
    private void genSum(TreeNode root, int currSum) {
        if (root.left == null && root.right == null) {
            sum += currSum * 10 + root.val;
            return;
        }
        if (root.left != null)
            genSum(root.left, currSum * 10 + root.val);

        if (root.right != null)
            genSum(root.right, currSum * 10 + root.val);
    }
}


