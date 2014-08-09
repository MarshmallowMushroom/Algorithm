/* recursive solution */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), candidates, 0, target);
        return result;
    }
    
    public void helper (List<List<Integer>> result, List<Integer> prev, int[] candidates, int index, int target) {
        if (index == candidates.length) {
            if (target == 0)
                result.add(prev);
            return;
        }
        int curr = candidates[index];
        List<Integer> tmp = new ArrayList<Integer>();
        while(target >= 0) {
            List<Integer> next = new ArrayList<Integer>(prev);
            next.addAll(tmp);
            helper(result, next, candidates, index + 1, target);
            target -= curr;
            tmp.add(curr);
        } 
    }
}
