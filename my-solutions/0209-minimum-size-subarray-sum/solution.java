class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        // 최소 길이를 구해야 하므로, 비교를 위해 가능한 최대값(또는 배열 길이 + 1)로 초기화합니다.
        int minLength = Integer.MAX_VALUE; 

        for (int right = 0; right < nums.length; right++) {
            // right 포인터를 이동하며 값을 더합니다.
            sum += nums[right];

            // 합이 target 이상이 되는 동안, 최대한 길이를 줄여봅니다.
            while (sum >= target) {
                // 현재 구간의 길이와 기존 최소 길이를 비교해 갱신합니다.
                minLength = Math.min(minLength, right - left + 1);
                
                // left를 오른쪽으로 옮기면서 값을 빼줍니다.
                sum -= nums[left];
                left++;
            }
        }

        // 만약 minLength가 초기값 그대로라면 조건을 만족하는 구간이 없다는 뜻이므로 0을 반환합니다.
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

