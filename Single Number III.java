public class Solution {
    public int[] singleNumber(int[] nums) {
        int t = 0;
        for(int i : nums) {
            t ^= i;
        }
        int mask = 1;
        while((t & mask) == 0) {
            mask *= 2;
        }
        int [] res = new int[2];
        for (int i : nums) {
            if ((i & mask) == 0) {
                res[0] ^= i;
            } else {
                res[1] ^= i;
            }
        }
        return res;
    }
}
