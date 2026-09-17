class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 문자가 가장 최근에 등장한 인덱스를 저장할 맵
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            // 만약 문자가 이미 맵에 존재하고, 
            // 그 문자의 위치가 현재 윈도우(left 이상) 안이라면 left 포인터를 갱신
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            
            // 현재 문자의 위치를 맵에 업데이트
            map.put(c, right);
            
            // 최대 길이를 계산해서 갱신 (오른쪽 - 왼쪽 + 1)
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
