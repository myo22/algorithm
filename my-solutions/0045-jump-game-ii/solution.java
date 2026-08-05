class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int maxJump = 0;
        int curEnd = 0;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if (i == curEnd) {
               curEnd = maxJump;  
               count++;
               
               if (curEnd >= n - 1) {
                  break;
               }     
            }           
            
        }
        return count;
    }
}
