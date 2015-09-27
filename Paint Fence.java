/*
Problem Description:

There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.
*/

//assume that s[i] is the number of ways when last two fence are the same color
//d[i] is the number f ways when the last two fence are different color.
// so we have s[i] = d[i-1]
// d[i] = (k-1)(s[i-1] + d[i-1]) = (k-1)(d[i-2] + d[i-1]);
// final result will be s[n-1] + d[n-1] = d[n-2] + d[n-1];

public int numWays(int n, int k) {
  if (n < 2) {
    return k;
  }
  int d1 = k; //d[i-2]
  int d2 = k * k-1; //d[i-1]
  for (int i=2; i<n; i++) {
    int tmp = d2;
    d2 = (k-1)*(d1 + d2);
    d1 = tmp;
  }
  return d1 + d2;
}
