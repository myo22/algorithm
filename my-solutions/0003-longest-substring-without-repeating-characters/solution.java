class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) >= left) {
                left = map.get(s.charAt(right)) + 1;
            } 
            map.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}
