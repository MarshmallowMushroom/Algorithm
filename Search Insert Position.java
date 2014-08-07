/*
s will hold the first position that is greater than the target, e will hold the first position that is less than the target
*/

public class Solution {
    public int searchInsert(int[] A, int target) {
        int s = 0;
        int e = A.length - 1;
        while(s <= e) {
            int m = (s + e)/2;
            if (A[m] == target)
                return m;
            if (target > A[m])
                s = m + 1;
            else
                e = m - 1;
        }
        return s;
    }
}
