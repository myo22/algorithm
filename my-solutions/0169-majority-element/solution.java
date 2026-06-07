class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        
        for (int num : nums) {
            // 카운트가 0이면 새로운 후보를 선정
            if (count == 0) {
                candidate = num;
            }
            
            // 후보와 같으면 count 증가, 다르면 감소
            count += (num == candidate) ? 1 : -1;
        }
        
        return candidate;
    }
}
