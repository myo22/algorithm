class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int current_end = 0;
        int maxreach = 0;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            maxreach = Math.max(maxreach, nums[i] + i);
            if (i == current_end) {
                count++;
                current_end = maxreach;
            }
        }
        return count;
    }
}
