class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[]{i , j});
                }             
            }
        }
        
        for (int[] a : list) {
            int x = a[0];
            int y = a[1];
            
            for (int i = 0; i < n; i++) {
                matrix[x][i] = 0;
            }
            
            for (int j = 0; j < m; j++) {
                matrix[j][y] = 0;
            }
        }
    }
}
