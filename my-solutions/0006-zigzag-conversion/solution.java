class Solution {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        
        int currentRow = 0;
        boolean flag = false;
        
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        for (int i = 0; i < s.length(); i++) {
            rows[currentRow].append(s.charAt(i));
            
            if (currentRow == 0 || currentRow == numRows - 1) {
                flag = !flag;
            }
            
            currentRow += flag ? 1 : -1;
        }
        
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }
        
        return sb.toString();
    }
}
