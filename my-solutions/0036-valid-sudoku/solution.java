class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                
                if (board[i][j] == '.') {
                    continue;
                }
                
                String row = i + "row" + board[i][j];
                String col = j + "col" + board[i][j];
                String box = (i / 3) + "box" + (j / 3) + "-" +board[i][j];
                
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
