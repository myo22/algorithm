class Solution {
    public int jump(int[] nums) {
        int min = 0;
        int lastIdx = 0;
        int curEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            lastIdx = Math.max(lastIdx, i + nums[i]);
            
            if (curEnd == i) {
                curEnd = lastIdx;
                min++;
            }
            
            if (curEnd >= nums.length - 1) {
                break;
            }
        }
        return min;
    }
}
