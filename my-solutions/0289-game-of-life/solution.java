class Solution {
    
    static int[][] dtm = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        int[][] nextBoard = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCount = getLiveNeighbors(board, i, j);
                
                if (board[i][j] == 1) {
                    if (liveCount < 2 || liveCount > 3) {
                        nextBoard[i][j] = 0;
                    } else {
                        nextBoard[i][j] = 1;
                    }
                } else {
                    if (liveCount == 3) {
                        nextBoard[i][j] = 1;
                    }
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = nextBoard[i][j];
            }
        }              
    }
    
    public int getLiveNeighbors(int[][] board, int x, int y) {        
        int m = board.length;
        int n = board[0].length;
        int cnt = 0;
        
        for (int i = 0; i < dtm.length; i++) {
            int dx = x + dtm[i][0];
            int dy = y + dtm[i][1];
            
            if (dx < 0 || dx >= m || dy < 0 || dy >= n) {
                continue;
            }
            
            if (board[dx][dy] == 1) {
                cnt++;
            }
        }
        
        return cnt;
    }
}

