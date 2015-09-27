/*
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
*/

public int findClosest(TreeNode root, int target) {
  int dist = closestDist(root, target);
  return target + dist;
}

private int closestDist(TreeNode root, int target) {
  if (root == null) {
    return Integer.MAX_VALUE;
  }
  int dist = root.val - target;
  int dist1 = closestDist(root.left, target);
  int dist2 = closestDist(root.right, target);
  return getMinDist(dist, dist1, dist2);
}

private int getMinDist(int i, int j, int k) {
  int[] arr = new int[3];
  arr[0] = i;
  arr[1] = j;
  arr[2] = k;
  int idx = 0;
  for (int p=1; p<3; p++) {
    if (Math.abs(arr[p]) < Math.abs(arr[idx])) {
      idx = p;
    }
  }
  return arr[idx];
}
