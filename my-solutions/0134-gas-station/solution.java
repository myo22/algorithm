class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSum = 0;
        int currentSum = 0;
        int startPoint = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalSum += diff;
            currentSum += diff;
            if (currentSum < 0) {
                startPoint = i + 1;
                currentSum = 0;
            }
        }
        return (totalSum) >= 0 ? startPoint : -1;
    }
}
