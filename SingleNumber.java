/*Given an array of integers, every element appears twice except for one. Find that single one.*/

public class Solution {
    public int singleNumber(int[] A) {
        int result = A[0];
        for (int i = 1; i < A.length; i++) {
            result ^= A[i];
        }
        return result;
    }
}
