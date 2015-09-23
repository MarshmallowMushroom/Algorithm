/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        //binary search
        long start = 1;
        long end  = n;
        while(start <= end) {
            int mid = (int)((start + end)/2);
            if (isBadVersion(mid)) {
                if (mid == 1 || !isBadVersion(mid-1)) {
                    return (int)mid;
                } else {
                    end = mid-1;
                }
            } else {
                start = mid+1;
            }
        }
        return n;
    }
}
