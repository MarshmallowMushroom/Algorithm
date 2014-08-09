/*the only difference is the duplicate*/ 
public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), num, 0, target);
        return result;
    }
    
    public void helper (List<List<Integer>> result, List<Integer> prev, int[] candidates, int index, int target) {
        if (index == candidates.length) {
            if (target == 0)
                result.add(prev);
            return;
        }
        int curr = candidates[index];
        int nextIndex = index + 1;
        while(nextIndex < candidates.length && candidates[nextIndex] == curr) { //find the next non-duplicate index
            nextIndex++;
        }
        List<Integer> tmp = new ArrayList<Integer>();
        while(target >= 0) {
            List<Integer> next = new ArrayList<Integer>(prev);
            next.addAll(tmp);
            helper(result, next, candidates, nextIndex, target);
            tmp.add(curr);
            index++;
            target -= curr;
            if (index > nextIndex)
                break;
        }
    }
}
