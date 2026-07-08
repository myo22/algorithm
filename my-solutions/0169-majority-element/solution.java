class Solution {
    public int majorityElement(int[] nums) {
        int cur = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cur == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
            
            if (cnt == 0) {
                cur = nums[i + 1];
            }
        }
        return cur;
    }
}
