class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int cur = nums[n - 1];
        int count = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (cur == nums[i]) {
                count++;
            } else {
                count--;
            }
            
            if (count == 0) {
                cur = nums[i];
                count = 1;
            }
        }
        return cur;
    }
}
