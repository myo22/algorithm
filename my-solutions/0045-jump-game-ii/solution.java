class Solution {
    public int jump(int[] nums) {
        int curEnd = 0;
        int fartest = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            fartest = Math.max(fartest, i + nums[i]);
            if (i == curEnd) {
                curEnd = fartest;
                count++;
                
                if (curEnd >= nums.length - 1) {
                    break;        
                }                 
            }           
        }
        return count;
    }
}
