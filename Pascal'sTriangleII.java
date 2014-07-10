/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        //init row 0 to contain 1
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> next = new ArrayList<Integer>();
            next.add(1);
            for (int j = 0; j < res.size()-1; j++) {
                next.add(res.get(j) + res.get(j+1));
            }
            next.add(1);
            res = next;    
        }
        return res;
    }
}
