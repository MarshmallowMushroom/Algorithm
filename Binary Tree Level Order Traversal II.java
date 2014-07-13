
/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> result = new ArrayList<ArrayList<TreeNode>>();
        ArrayList<ArrayList<Integer>> intRes = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return intRes;
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        curr.add(root);
        while(!curr.isEmpty()) {
            ArrayList<TreeNode> next = new ArrayList<TreeNode>();
            for (TreeNode n : curr) {
                if (n.left != null)
                    next.add(n.left);
                if (n.right != null)
                    next.add(n.right);
            }
            result.add(curr);
            curr = next;
        }
        for (int i = result.size() - 1; i >= 0; i--) {
            ArrayList<Integer> intList = new ArrayList<Integer>();
            for (TreeNode n : result.get(i)) {
                intList.add(n.val);
            }
            intRes.add(intList);
        }
        return intRes;
    }
}
