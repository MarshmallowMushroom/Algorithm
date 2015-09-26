/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
*/

Class Pair {
  int x;
  int y;
  public Pair(int i, int j) {
    this.x = i;
    this.y = j;
  }
}

public void wallsAndGates(int[][] matrix) {
  for (int i=0; i<matrix.length; i++) {
    for (int j=0; j<matrix.length; j++) {
      bfs(i, j, matrx);
    }
  }
}

private void bfs(int i, int j, int[][] matrix) {
  if (matrix[i][j] != 0) {
    return;
  }
  Stack<Pair> bfsStack = new Stack<Pair>();
  bfsStack.push(new Pair(i, j));
  int dst = 1;
  while(bfsStack.isEmpty()) {
    Pair p = bfsStack.pop();
    if (isValid(p.x+1, p.y, matrix, dst) {
      matrix[i+1][j] = dst;
      bfsStack.push(new Pair(i+1, j));
    }
    if (isValid(p.x-1, p.y, matrix, dst) {
      matrix[i-1][j] = dst;
      bfsStack.push(new Pair(i-1, j));
    }
    if (isValid(p.x, p.y+1, matrix, dst) {
      matrix[i][j+1] = dst;
      bfsStack.push(new Pair(i, j+1));
    }
    if (isValid(p.x, p.y-1, matrix, dst) {
      matrix[i][j-1] = dst;
      bfsStack.push(new Pair(i, j-1));
    }
    dst++;
  }
}

private boolean isValid(int i, int j, int[][] matrix, int dst) {
  if (i < 0 || i >= matrix.length || matrix[i][j] == -1 || matrix[i][j] <= dst) {
    return false;
  }
  return true;
}
