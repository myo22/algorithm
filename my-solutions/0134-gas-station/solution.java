class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0;
        int curGas = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            curGas += gas[i];
            curGas -= cost[i];
            total += gas[i];
            total -= cost[i];
            if (curGas < 0) {
                start = i + 1;
                curGas = 0;
            }
        }
        if (total < 0) start = -1;
        return start;
    }
}
