class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // s의 문자가 t의 어떤 문자에 대응되는지 저장하는 맵
        Map<Character, Character> sMap = new HashMap<>();
        // t의 문자가 s의 어떤 문자에 대응되는지 저장하는 맵 (역방향 1:1 대응 체크용)
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // 1. 이미 c1이 다른 문자에 매핑된 적이 있는데, 이번 문자가 다르면 false
            if (sMap.containsKey(c1) && sMap.get(c1) != c2) {
                return false;
            }
            
            // 2. 반대로 c2도 이미 다른 문자에 매핑된 적이 있는데, 이번 문자가 다르면 false (1:1 대응 검증)
            if (tMap.containsKey(c2) && tMap.get(c2) != c1) {
                return false;
            }

            // 맵에 매핑 정보 저장
            sMap.put(c1, c2);
            tMap.put(c2, c1);
        }

        return true;
    }
}

