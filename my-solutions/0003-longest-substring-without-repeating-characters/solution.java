class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = Integer.MIN_VALUE;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char a = s.charAt(right);
            if (map.containsKey(a) && left <= map.get(a)) {
                left = map.get(a) + 1;
            }
            map.put(a, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
