class Solution {
    public int removeDuplicates(int[] nums) {
        int current = nums[0];
        int k = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == current) {
                if (count < 2) {
                    count++;
                    nums[k++] = nums[i];                  
                }              
            } else {
                count = 1;
                current = nums[i];
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
