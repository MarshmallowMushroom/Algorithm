/**
 * Definition for binary tree
/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
*/


/*
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flat(root);
    }
    
    public TreeNode flat(TreeNode root) {
        if(root.left == null && root.right == null)
            return root;
        if (root.left == null){
            return flat(root.right);
        }
        if (root.right == null) {
            TreeNode left = flat(root.left);
            root.right = root.left;
            root.left = null;
            return left;
        }
        TreeNode left = flat(root.left);
        TreeNode right = flat(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        left.right = tmp;
        return right;
    }
}
/* a iterative solution, keep merging the left subtree to the rightsub tree until all the left subtrees are merged*/
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
    public void flatten(TreeNode root) {
        while(root != null) {
            if (root.left != null) {
                TreeNode rightMost = root.left;
                while(rightMost.right != null) { //find the right Most of the left sub tree
                    rightMost = rightMost.right;
                }
                TreeNode tmp = root.right;
                root.right = root.left;
                root.left = null;
                rightMost.right = tmp;
            }
            root = root.right;
        }
    }
}
