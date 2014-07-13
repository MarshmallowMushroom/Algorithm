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
    int p;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        p = postorder.length - 1;
        //generate inorderMap for quick lookup of the index in inorder traversal list
        HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(inorderMap, postorder, 0, inorder.length - 1);
    }
    
    public TreeNode buildTreeHelper(HashMap<Integer, Integer> inorderMap, int [] postorder, int start, int end) {
        if (start > end)
            return null;
        if (start == end) {
            TreeNode tmp = new TreeNode(postorder[p]);
            p--;
            return tmp;
        }
        int rootIndex = inorderMap.get(postorder[p]);
        TreeNode root = new TreeNode(postorder[p]);
        p--;
        TreeNode right = buildTreeHelper (inorderMap, postorder, rootIndex + 1, end);
        TreeNode left = buildTreeHelper(inorderMap, postorder, start, rootIndex - 1);
        root.left = left;
        root.right = right;
        return root;
    }
}
