class Solution {
    public String intToRoman(int num) {
        int[] symbol = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] value = {"M", "CM", "D","CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        String answer = "";     
        for (int i = 0; i < symbol.length; i++) {
            int cnt = num / symbol[i];
            num %= symbol[i];
            for (int j = 0; j < cnt; j++) {
                answer += value[i];
            }
        }
        return answer;
    }
}
