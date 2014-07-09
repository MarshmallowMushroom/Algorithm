public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0)
            return;
        //first and last row
        for (int c = 0; c < board[0].length; c++) {
            bfs(board, 0, c);
            bfs(board, board.length - 1, c);
        }
        //first and last col
        for (int r = 0; r < board.length; r++) {
            bfs(board, r, 0);
            bfs(board, r, board[0].length - 1);
        }
        
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'O')
                    board[r][c] = 'X';
            }
        }
        
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'Y')
                    board[r][c] = 'O';
            }
        }
    }
    
    public void bfs(char[][] board, int r, int c) {
        if (board[r][c] == 'O') {
            Queue<Integer> fifor = new LinkedList<Integer>();
            Queue<Integer> fifoc = new LinkedList<Integer>();
            fifor.add(r);
            fifoc.add(c);
            //mark Y when enqueue, if mark Y when dequeue, duplicate would happen.
            board[r][c] = 'Y';
            while(!fifor.isEmpty()) {
                int Rtmp = fifor.poll();
                int Ctmp = fifoc.poll();
                
                if (Rtmp - 1 >= 0 && board[Rtmp - 1][Ctmp] == 'O') {
                    fifor.add(Rtmp-1);
                    fifoc.add(Ctmp);
                    board[Rtmp-1][Ctmp] = 'Y';
                }
                if (Rtmp + 1 < board.length && board[Rtmp + 1][Ctmp] == 'O') {
                    fifor.add(Rtmp + 1);
                    fifoc.add(Ctmp);
                    board[Rtmp+1][Ctmp] = 'Y';
                }
                if (Ctmp - 1 >= 0 && board[Rtmp][Ctmp - 1] == 'O') {
                    fifor.add(Rtmp);
                    fifoc.add(Ctmp - 1);
                    board[Rtmp][Ctmp-1] = 'Y';
                }
                if (Ctmp + 1 < board[0].length && board[Rtmp ][Ctmp + 1] == 'O') {
                    fifor.add(Rtmp);
                    fifoc.add(Ctmp + 1);
                    board[Rtmp][Ctmp+1] = 'Y';
                }    
            }
        }
    }
}
