/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*/

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;
        for (int i = triangle.size() - 1; i > 0; i--) {
            List<Integer> curr = triangle.get(i);
            List<Integer> prev = triangle.get(i-1);
            for (int j = 0; j < curr.size() - 1; j++) {
                int min = Math.min(curr.get(j), curr.get(j+1));
                prev.set(j, prev.get(j) + min);
            }
        }
        return triangle.get(0).get(0);
    }
}
