class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] arr = new int[123];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)] += 1;
        }
        
        for (int i = 0; i < t.length(); i++) {
            if (arr[t.charAt(i)] < 1) {
                return false;
            }
            arr[t.charAt(i)] -= 1;
        }
        
        return true;
    }
}
