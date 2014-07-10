/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0)
            return res;
        //init the first row to 1
        List<Integer> curr = new ArrayList<Integer>();
        curr.add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> next = new ArrayList<Integer>();
            next.add(1);
            for (int j = 0; j < curr.size() - 1; j++) {
                next.add(curr.get(j) + curr.get(j+1));
            }
            next.add(1);
            res.add(curr);
            curr = next;
        }
        //add the final curr 
        res.add(curr);
        return res;
    }
}
