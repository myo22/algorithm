class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] chr = str.toCharArray();
            Arrays.sort(chr);
            
            String key = new String(chr);
            map.putIfAbsent(key, new ArrayList<>());
            
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
