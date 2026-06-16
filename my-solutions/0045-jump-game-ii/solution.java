class Solution {
    public int jump(int[] nums) {
        int maxIdx = 0;
        int curEnd = 0;
        int k = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxIdx = Math.max(maxIdx, i + nums[i]);
            
            if (curEnd >= nums.length - 1) {
                break;
            }
            
            if (curEnd == i) {
                curEnd = maxIdx;
                k++;
            }                    
        }
        return k;
    }
}
