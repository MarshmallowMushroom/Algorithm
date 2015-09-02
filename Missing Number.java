public class Solution {
    public int missingNumber(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if (nums[i] < nums.length) {
                while(nums[i] != i && nums[i] < nums.length) {
                    swap(nums, i, nums[i]);
                }
            }
        }
        for(int i=0; i<nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
