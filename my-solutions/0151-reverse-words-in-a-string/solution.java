class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String word = "";
        String answer = "";
        for (int i = 0; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) != ' ') {
                word += s.charAt(i);
            } else if (word.length() > 0 && answer.length() > 0) {
                answer = word + " " + answer;
                word = "";
            } else if (word.length() > 0) {
                answer = word;
                word = "";
            }
        }
        return answer;
    }
}
