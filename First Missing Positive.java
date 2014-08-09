public class Solution {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length) {
            if (A[i] == i + 1 || A[i] < 1 || A[i] > A.length || A[i] == A[A[i] - 1]) //advance to next index
                i++;
            else
                swap(A, i, A[i] - 1);
        }
        //go over the array to find the first missing positive number
        for (int j = 0; j < A.length; j++) {
            if (A[j] != j + 1)
                return j + 1;
        }
        return A.length + 1;
    }
    
    public void swap(int[] A, int i1, int i2) { //swap index i1 and i2 in A without using extra variable
        A[i1] = A[i1] ^ A[i2];
        A[i2] = A[i1] ^ A[i2];
        A[i1] = A[i1] ^ A[i2];
    }
}
