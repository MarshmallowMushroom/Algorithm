/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //revert level by level, or we can do it recursively. 
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        List<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        while (!level.isEmpty()) {
           List<TreeNode> nextLevel = new ArrayList<TreeNode>();
           for (TreeNode t : level) {
               TreeNode tmp = t.left;
               t.left = t.right;
               t.right = tmp;
               if (t.left != null)
                    nextLevel.add(t.left);
                if (t.right != null)
                    nextLevel.add(t.right);
               
           }
           level = nextLevel;
        }
        return root;
    }
}
