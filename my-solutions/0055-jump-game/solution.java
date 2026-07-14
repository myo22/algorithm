class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            
            if(i > max) {
                return false;
            }
            
            max = Math.max(nums[i] + i, max);
             
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
