class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] str = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            str[i] = new StringBuilder();
        }

        int index = 0;
        int direction = -1;

        for (int i = 0; i < s.length(); i++) {
            str[index].append(s.charAt(i));
            
            if (index == 0 || index == numRows - 1) {
                direction *= -1;
            }
            index += direction;
        }

        StringBuilder answer = new StringBuilder();
        for (StringBuilder sb : str) {
            answer.append(sb);
        }

        return answer.toString();
    }
}

