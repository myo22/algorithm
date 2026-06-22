class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int current = 0;
        int startIdx = 0;
        int totalTank = 0;
        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            current += diff;
            totalTank += diff;
            
            if (current < 0) {
                startIdx = i + 1;
                current = 0;
            }
        }
        return totalTank >= 0 ? startIdx : -1;
    }
}
