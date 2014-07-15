public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int aSize = A.length;
        int bSize = B.length;
        if ((aSize + bSize) % 2 == 0) // if even total number of element
            return (helper(A, B, 0, aSize - 1, 0, bSize - 1, (aSize + bSize)/2 - 1) + helper(A, B, 0, aSize - 1, 0, bSize - 1, (aSize + bSize)/2))/2;
        else // odd total number of element
            return helper(A, B, 0, aSize - 1, 0, bSize - 1, (aSize + bSize)/2);
    }
    
    private double helper(int A[], int B[], int aStart, int aEnd, int bStart, int bEnd, int k) {
        if (aStart > aEnd) // A is empty
            return B[bStart + k];
        if (bStart > bEnd) // B is empty
            return A[aStart + k];
        if (k == 0)
            return Math.min(A[aStart], B[bStart]);
            
        int aMid = (aStart + aEnd)/2;
        int bMid = (bStart + bEnd)/2;
        if (A[aMid] <= B[bMid]) {
            if (k <= (aMid - aStart) + (bMid - bStart)) {
                return helper(A, B, aStart, aEnd, bStart, bMid - 1, k);
            }
            else {
                return helper(A, B, aMid + 1, aEnd, bStart, bEnd, k - (aMid - aStart + 1));
            }    
        }
        else {
            if (k <= (aMid - aStart) + (bMid - bStart)) {
                return helper(A, B, aStart, aMid - 1, bStart, bEnd, k); 
            }
            else {
                return helper(A, B, aStart, aEnd, bMid + 1, bEnd, k - (bMid - bStart + 1));
            }
        }
    }
}
