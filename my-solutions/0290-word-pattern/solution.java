class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sa = s.split(" ");
        if (pattern.length() != sa.length) return false;

        Map<Object, Integer> map = new HashMap<>();

        for (Integer i = 0; i < pattern.length(); i++) {
            if (map.put(pattern.charAt(i), i) != map.put(sa[i], i)) {
                return false;
            }
        }

        return true;
    }
}

