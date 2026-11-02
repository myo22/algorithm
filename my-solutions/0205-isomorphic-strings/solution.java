class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] map1 = new int[255];
        int[] map2 = new int[255];
        
        for (int i = 0; i < s.length(); i++) {
            char sr = s.charAt(i);
            char tr = t.charAt(i);
            
            if (map1[sr] != map2[tr]) {
                return false;
            }
            
            map1[sr] = i + 1;
            map2[tr] = i + 1;
        }
        
        return true;
    }
}
