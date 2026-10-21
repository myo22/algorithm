class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 1. magazine의 문자 개수를 담을 맵 생성 (Key: 문자, Value: 개수)
        Map<Character, Integer> map = new HashMap<>();
        
        // 2. magazine을 돌면서 각 문자의 개수를 getOrDefault로 기록
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // 3. ransomNote 길이만큼 for문을 돌며 문자 확인
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            
            // 맵에 문자가 없거나, 필요한 개수보다 가진 게 부족(0 이하)하면 false
            if (!map.containsKey(c) || map.get(c) <= 0) {
                return false;
            }
            
            // 문자를 하나 사용했으므로 맵에서 개수를 1 감소시킴
            map.put(c, map.get(c) - 1);
        }
        
        // 문제가 없다면 전부 만들 수 있다는 뜻이므로 true 반환
        return true;
    }
}

