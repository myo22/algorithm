class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        boolean goingDown = false;
        int currRow = 0;
        
        for (char c : s.toCharArray()) {
            rows[currRow].append(c);

            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currRow += goingDown ? 1 : -1;
        }
        
        String answer = "";
        for (StringBuilder sb : rows) {
            answer += sb;
        }
        
        return answer;
    }
}
