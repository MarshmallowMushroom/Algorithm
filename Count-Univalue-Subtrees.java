Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:

Given binary tree,

1
    5
   / \
  1   5
 / \   \
5   5   5
return 4.

int count;
public int CountUnivalueSubtrees(TreeNode root) {
  count = 0;
  if (root == null) {
    return 0;
  }
  helper(root);
  return count;
}

private boolean helper(root) {
  if (root.left == null && root.right == null) {
    count++;
    return true;
  }
  if (root.left == null) {
    if (root.right.val == root.val && helper(root.val)) {
      count++;
      return true;
    }
    return false;
  }
  if (root.right == null) {
    if (root.left.val == root.val && helper(root.val)) {
      count++;
      return true;
    }
    return false;
  }
  
  if (root.val == root.left.val && root.val == root.right.val && helper(root.left) && helper(root.right)) {
    return true;
  }
  return false;
}
