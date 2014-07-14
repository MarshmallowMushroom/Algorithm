public class Solution {
    public boolean exist(char[][] board, String word) {
        boolean [][] visited = new boolean [board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (bfs(board, visited, r, c, word))
                    return true;
            }
        }
        return false;
    }
    
    private boolean bfs(char[][] board, boolean [][] visited, int row, int col, String word) {
        if (board[row][col] != word.charAt(0) || visited[row][col]) {
            return false;
        }
        if (word.length() == 1) {
            return true;
        }
        String next = word.substring(1);
        visited[row][col] = true;
        boolean found = false;
        if (row - 1 >= 0 && bfs(board, visited, row - 1, col, next))
            return true;
        if (row + 1 < board.length && bfs(board, visited, row + 1, col, next))
            return true;
        if (col - 1 >= 0 && bfs(board, visited, row, col - 1, next))
            return true;
        if (col + 1 < board[0].length && bfs(board, visited, row, col + 1, next))
            return true;
        //set the visited[row][col] back to false so it can be explored by the other bfs
        visited[row][col] = false;
        return false;
    }
}
