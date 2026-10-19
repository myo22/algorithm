class Solution {
    public boolean isValidSudoku(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        
        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                
                String row = "row" + i + "-" + board[i][j];
                String col = board[i][j] + "-" + j + "col";
                String box = "box" + (i / 3) + "-" + board[i][j] + "-" + (j / 3);
                
                if (set.contains(row) || set.contains(col) || set.contains(box)) {
                    return false;
                }
                
                set.add(row);
                set.add(col);
                set.add(box);
            }
        }
        return true;
    }
}
