public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length <= 1) {
            return;
        }
        int start = 0;
        int end = matrix.length-1;
        while(start < end) {
            //first row
            for (int i = 0; i < end - start; i++) {
                int tmp = matrix[start][start+i];
                matrix[start][start+i] = matrix[end - i][start];
                matrix[end - i][start] = matrix[end][end - i];
                matrix[end][end - i] = matrix[start + i][end];
                matrix[start + i][end] = tmp;
            }
            start++;
            end--;
        }
    }
}
