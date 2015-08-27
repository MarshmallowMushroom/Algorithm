public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums.length == 0)
            return res;
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        int n1 = 0;
        int n2 = 0;
        int c1 = 0;
        int c2 = 0;
        for (int i=0; i<nums.length; i++) {
            if (c1 == 0) {
                n1 = nums[i];
                c1 = 1;
            } else if (n1 == nums[i]) { // order is very important, here we want to make sure that n1 and n2 are different numbers
                c1++;
            } else if (c2 == 0) {
                n2 = nums[i];
                c2 = 1;
            } else if (n2 == nums[i]) {
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for(int i=0; i<nums.length; i++) {
            if (nums[i] == n1)
                c1++;
            if (nums[i] == n2)
                c2++;
        }
        if (c1 > nums.length/3)
            res.add(n1);
        if (c2 > nums.length/3 && n1 != n2) {
            res.add(n2);
        }
        return res;
    }
}
