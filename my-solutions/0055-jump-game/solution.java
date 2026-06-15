class Solution {
    public boolean canJump(int[] nums) {
        int lastIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lastIdx < i) {
                return false;
            }
            
            lastIdx = Math.max(lastIdx, i + nums[i]);
            if (lastIdx >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}
