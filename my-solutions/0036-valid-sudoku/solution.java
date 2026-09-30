class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char current = board[r][c];
              
                if (current == '.') {
                    continue;
                }

                String rowKey = r + "row" + current;
                String colKey = current + "col" + c;
                String boxKey = (r / 3) + "-" + (c / 3) + "box" + current;

                if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(boxKey)) {
                    return false;
                }
               
                seen.add(rowKey);
                seen.add(colKey);
                seen.add(boxKey);
            }
        }

        return true;
    }
}

