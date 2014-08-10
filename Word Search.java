/*use depth first search, using the call stack to implement*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0)
            return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(r, c, word, board, visited))
                    return true;
            }
        }
        return false;
    }
    
    public boolean dfs(int r, int c, String t, char[][] board, boolean[][] visited) {
        if (t.length() == 0)
            return true;
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c] || t.charAt(0) != board[r][c])
            return false;
        visited[r][c] = true;
        if (dfs(r + 1, c, t.substring(1), board, visited))
            return true;
        if (dfs(r - 1, c, t.substring(1), board, visited))
            return true;
        if (dfs(r, c + 1, t.substring(1), board, visited))
            return true;
        if (dfs(r, c - 1, t.substring(1), board, visited))
            return true;
        visited[r][c] = false;
        return false;
    }
}
