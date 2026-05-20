class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        boolean isChar = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                isChar = true;
            }
            if (isChar && s.charAt(i) == ' ') {
                break;
            }
            if (isChar) {
                count++;
            }
        }        
        return count;
    }
}
