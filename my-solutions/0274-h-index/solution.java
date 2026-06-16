class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        
        int n = citations.length;
        int h = 0;
        
        for (int i = 0; i < n; i++) {
            int val = citations[n - 1 - i];
            
            // h+1편의 논문이 최소 h+1번 인용되었는지 확인
            if (val >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }
        return h;
    }
}

