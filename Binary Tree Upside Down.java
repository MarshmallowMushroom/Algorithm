/*
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
1
/ \
2 3
/ \
4 5

return the root of the binary tree [4,5,2,#,#,3,1].
4
/ \
5 2
  / \
 3 1
 */
 
//bottom up approach
public TreeNode UpsideDownBinaryTree(TreeNode root) {  
  if (root == null) {
    return root;
  }
  TreeNode curr = root;
  TreeNode l = root.left;
  TreeNode r = root.right;
  
  if (l != null) {
    TreeNode rtn = UpsdeDownBinaryTree(l);
    l.right = curr;
    l.left = r;
    return rtn;
  }
  return curr
}

//top down approach (iterative) think of reverse linkedlist
public TreeNode UpsideDownBinaryTree(TreeNode root) {  
  if (root == null) {
    return root;
  }
  TreeNode curr = root;
  TreeNode l = null;
  TreeNode r = null;
  TreeNode parent = null;
  TreeNode parentRight = null
  while(curr != null) {
    l = curr.left;
    r = curr.right;
    curr.right = parent;
    curr.left = parentRight;
    parentRight = r;
    parent = curr;
    curr = l;
  }
  return 
}
