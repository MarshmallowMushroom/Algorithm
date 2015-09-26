public TreeNode inorderSuccessorBST(TreeNode root, TreeNode target) {
  return helper(root, target, null);
}

private TreeNode helper(TreeNode root, TreeNode target, TreeNode parent) {
  if (root == target) {
    if (root.left != null) {
      return leftMost(root.left);
    }
    return parent;
  }
  TreeNode left = helper(root.left, target, root);
  if (left != null) {
    return left;
  }
  return helper(root.right, target, null);
  
}

public find leftMost(TreeNode node) {
  if (node.left == null) {
    return null;
  }
  return leftMost(node.left);
}
