public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[0];
        Deque<Integer> dq = new LinkedList<Integer>();
        int[] res = new int[nums.length-k+1];
        for(int i=0; i<nums.length; i++) {
            while(!dq.isEmpty() && dq.peekLast() < nums[i]) {
                dq.removeLast();
            }
            dq.add(nums[i]);
            if (i-k >= 0 && nums[i-k] == dq.peekFirst())
                dq.removeFirst();
            if (i - k + 1 >= 0) {
                res[i-k+1] = dq.peekFirst();
            }
        }
        return res;
    }
}
