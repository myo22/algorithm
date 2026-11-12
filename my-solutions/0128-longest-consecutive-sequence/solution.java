class Solution {
    public int longestConsecutive(int[] nums) {
        // 예외 처리: 배열이 비어있으면 길이는 0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // TreeSet을 사용하면 중복이 제거되고 동시에 오름차순으로 정렬됩니다.
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Set에 담긴 고유한 값들을 다시 배열로 변환
        int[] uniqueNums = new int[set.size()];
        int idx = 0;
        for (int num : set) {
            uniqueNums[idx++] = num;
        }

        int count = 1;
        int max = 1; // 최소 길이는 1이므로 1로 초기화

        // 정렬 및 중복 제거된 배열 순회
        for (int i = 0; i < uniqueNums.length - 1; i++) {
            if (uniqueNums[i] + 1 == uniqueNums[i + 1]) {
                count++; // 연속되면 count 증가
            } else {
                if (max < count) {
                    max = count; // 최대값 갱신
                }
                count = 1; // 연속이 끊기면 count 리셋
            }
        }
        
        // 마지막에 끝난 수열의 길이도 비교해줍니다.
        if (max < count) {
            max = count;
        }

        return max;
    }
}

