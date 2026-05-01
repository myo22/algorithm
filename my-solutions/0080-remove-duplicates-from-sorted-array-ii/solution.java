class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
                count = 1;
            } else {
                if (count == 1) {
                    nums[k++] = nums[i];
                    count++;
                }
            }
        }
        return k;
    }
}
