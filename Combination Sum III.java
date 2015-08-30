public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return helper(1, k, n);
    }
    
    private List<List<Integer>> helper(int start, int k, int t) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k == 0) {
            if (t == 0) {
                List<Integer> tmp = new ArrayList<Integer>();
                result.add(tmp);
            }
            return result;
        }
        
        if (9-start + 1 < k || t <= 0) {
            return result;
        }
        
        for(int i=start; i<=9; i++) {
            List<List<Integer>> res = helper(i+1, k-1, t-i);
            for(List<Integer> list : res) {
                list.add(0, i);
                result.add(list);
            }
        }
        return result;
    }
}
