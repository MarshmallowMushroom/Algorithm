/*
Given the binary Tree and the two nodes say ‘a’ and ‘b’, determine whether the two nodes are cousins of each other or not.

Two nodes are cousins of each other if they are at same level and have different parents.

Example

     6
   /   \
  3     5
 / \   / \
7   8 1   3
Say two node be 7 and 1, result is TRUE.
Say two nodes are 3 and 5, result is FALSE.
Say two nodes are 7 and 5, result is FALSE.
*/

/*Analysis:
The problem can be approached in two steps. 1. find the parent of both target node. 2. check if they are the same? -> if so return false. If they are in the same level -> true. if in different level -> false;
*/

public class solution {
    private TreeNode findParent(TreeNode root, int target) { //return a reference to the parent of the target
        if (root.left == null && root.right == null) // if hit the root
            return null;
        TreeNode left = null;
        TreeNode right = null;
        if (root.left != null) {
            if (root.left.val == target) // find the target in the left child
                return root;
            left = findParent(root.left, target);
        }
        if (root.right != null) {
            if (root.right.val == target)
                return root;
            right = findParent(root.right, target);
        }
        if (left != null)
            return left;
        return right;
    }
    
    private int findLevel(TreeNode root, TreeNode target) {
        if (root == null)
            return -1;
        if (root == target)
            return 0;
        int left = findLevel(root.left, target);
        int right = findLevel(root.right, target);
        if (left != -1)
            return left + 1;
        if (right != -1)
            return right + 1;
        return -1; 
    }    
    
    public boolean isCousin(TreeNode root, int n1, int n2) {
        TreeNode p1 = findParent(root, n1);
        TreeNode p2 = findParent(root, n2);
        if (p1 == null || p2 == null || p1 == p2)
            return false;
        return findLevel(root, p1) == findLevel(root, p2);
    }
}
