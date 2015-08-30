public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k==0)
            return false;
        int i = 0;
        int j = 0;
        TreeSet<Integer> visited = new TreeSet<Integer>();
        for (; j<nums.length; j++) {
            if (!visited.isEmpty()) {
                if (check(nums[j], t, visited))
                    return true;
            }
            visited.add(nums[j]);
            if (j-i >= k) {
                visited.remove(nums[i]);
                i++;
            }
        }
        return false;
    }
    
    private boolean check(int n, int t, TreeSet<Integer> visited) {
        Integer a1 = visited.ceiling(n);
        Integer a2 = visited.floor(n);
        if (a1 != null) {
            if ((long)a1 - (long)n <= (long)t)
                return true;
        }
        if (a2 != null) {
            if ((long)n - (long)a2 <= (long)t)
                return true;
        }
        return false;
    }
}
