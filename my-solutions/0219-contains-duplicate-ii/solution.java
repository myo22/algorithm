class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer exist = map.put(nums[i], i);
            if (exist == null) {
                continue;
            }
            
            if (Math.abs(i - exist) <= k) {
                return true;
            }
        }
        return false;
    }
}
