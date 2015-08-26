public class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int min = nums[0];
        while(start <= end) {
            int mid = (start + end)/2;
            min = Math.min(min, nums[mid]);
            min = Math.min(min, nums[start]);
            min = Math.min(min, nums[end]);
            if (nums[mid] < nums[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            
        }
        return min;
    }
}
