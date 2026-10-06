class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                
                char current = board[r][c];
                
                if (current == '.') {
                    continue;
                }
                
                String rowKey = r + "row" + current;
                String colKey = current + "col" + c;
                String boxKey = (r / 3) + "box" + (c / 3) + "-" + current;
                
                if (set.contains(rowKey) || set.contains(colKey) || set.contains(boxKey)) {
                    return false;
                }
                
                set.add(rowKey);
                set.add(colKey);
                set.add(boxKey);
            }
        }
        return true;
    }
}
