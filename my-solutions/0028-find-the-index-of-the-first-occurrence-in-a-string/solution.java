class Solution {
    public int strStr(String haystack, String needle) {
        int hlen =  haystack.length();
        int nlen = needle.length();
        for (int i = 0; i <= hlen - nlen; i++) {
            int j;
            for (j = 0; j < nlen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            
            if (j == nlen) {
                return i;
            }
        }
        return -1;
    }
}
