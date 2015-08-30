public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int[][] minSquare = new int [matrix.length][matrix[0].length];
        int max = 0;
        for (int r = 0; r<matrix.length; r++) {
            for(int c=0; c<matrix[0].length; c++) {
                if (matrix[r][c] == '0') {
                    minSquare[r][c] = 0;
                } else {
                    if (r==0 || c== 0) {
                        minSquare[r][c] = 1;
                    } else {
                        minSquare[r][c] = minOfThree(minSquare[r-1][c-1], minSquare[r][c-1], minSquare[r-1][c]) + 1;
                    }
                    max = Math.max(minSquare[r][c], max);
                }
            }
        }
        return max*max;
    }
    
    private int minOfThree(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
