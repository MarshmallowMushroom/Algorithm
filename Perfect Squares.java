public class Solution {
    public int numSquares(int n) {
        int[] minSquare = new int [n+1];
        minSquare[0] = 0;
        for (int i=1; i<=n; i++) {
            int j = 1;
            minSquare[i] = i;
            while(j*j <= i) {
                int min = minSquare[i-j*j] + 1;
                minSquare[i] = Math.min(min, minSquare[i]);
                j++;
            }
        }
        return minSquare[n];
    }
}
