class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 1. Value를 List<String>으로 선언하여 여러 단어를 담을 수 있게 합니다.
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // 문자를 char 배열로 바꾸고 정렬해서 Key로 쓸 문자열을 만듭니다.
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);

            // 해당 키가 처음 나왔다면 빈 리스트를 만들어 줍니다.
            map.putIfAbsent(sortedKey, new ArrayList<>());

            // 원래 단어를 해당 키의 리스트에 쏙 집어넣습니다. (for문 한 번으로 끝!)
            map.get(sortedKey).add(s);
        }

        // 2. 맵에 모인 값(Value)들만 꺼내서 리스트로 반환합니다.
        return new ArrayList<>(map.values());
    }
}
