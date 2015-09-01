/*
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red;costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.
*/

//use dynamic programming, create a 2d array minPrice[i][j] indicating paint house i to color j
// minPrice[i][j] = minOf(minPrice[i-1][0 ~ totalnumber of colors except j]};

public int minCost(int[][] cost) {
  int[][] minPrice = new int[cost.length][3];
  for(int i=0; i<cost.length; i++) {
    if (i == 0) {
      minPrice[i][0] = cost[i][0];
      minPrice[i][1] = cost[i][1];
      minPrice[i][2] = cost[i][2];
    } else {
      minPrice[i][0] = Math.min(minPrice[i-1][1], minPrice[i-1][2]) + cost[i][0];
      minPrice[i][1] = Math.min(minPrice[i-1][0], minPrice[i-1][2]) + cost[i][1];
      minPrice[i][2] = Math.min(minPrice[i-1][0], minPrice[i-1][1]) + cost[i][2];
    }
}

//notice that we actually do not need a 2d array, we only care about the line that is above the current line, so we could save the 2d array and only use a array of 3 to track the previous line
