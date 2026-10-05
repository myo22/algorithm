class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        
        int l = 0, r = 0, dir = 0;
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};
        
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m * n; i++) {
            list.add(matrix[l][r]);
            visited[l][r] = true;
            
            int dx = l + dirX[dir];
            int dy = r + dirY[dir];
            
            if (dx < 0 || dx >= m || dy < 0 || dy >= n || visited[dx][dy]) {
                dir = (dir + 1) % 4;
                dx = l + dirX[dir];
                dy = r + dirY[dir];
            }
            l = dx;
            r = dy;
        }
        return list;
    }
}
