class Solution {
    public boolean canJump(int[] nums) {
        int lastidx = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (lastidx < i) {
                return false;
            }
            lastidx = Math.max(lastidx, i + nums[i]);
        }
        if (lastidx >= nums.length - 1) {
            flag = true;
        }
        return flag;
    }
}
