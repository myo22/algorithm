class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().replaceAll(" +", " ").split(" ");
        String answer = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            answer += arr[i];
            if (i != 0) {
                answer += " ";
            }
                  }
                  return answer;
    }
}
