/*
Given a 2d array, find the the shape count. 
A shape is defined as continuous (left, right, top, bottom) 1s in the array.
The 2d array only contains 0s and 1s
e.g:
[
  [101]
  [010]
  [111]
]

count = 3

e.g 2
[
  [111]
  [001]
  [111]
]

count = 1


e.g 3
[
  [111111111111]
  [000000000001]
  [111000000001]
  [100000100001]
  [100000000001]
  [100000000001]
  [111111111111]

]
count = 2
*/
public class solution {
	public int countShape(int [][] matrix) {
		//use recursive dfs to search the shape
		boolean [][] visited = new boolean [matrix.length][matrix[0].length];
		int count = 0;
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {	
				if (matrix[r][c] == 1 && !visited[r][c]) {
					dfs(matrix, visited, r, c);
					count++;
				}
			}
		}
		return count;
	}
	
	//recursive dfs for the matrix
	public void dfs (int [][] matrix, boolean [][] visited, int r, int c) {
		if (matrix[r][c] == 0 || visited[r][c])
			return;
		visited[r][c] = true;
		if (r - 1 >= 0)
			dfs(matrix, visited, r - 1, c);
		if (r + 1 < matrix.length)
			dfs(matrix, visited, r + 1, c);
		if (c - 1 >= 0)
			dfs(matrix, visited, r, c - 1);
		if (c + 1 < matrix[0].length)
			dfs(matrix, visited, r, c + 1);
	}
}
