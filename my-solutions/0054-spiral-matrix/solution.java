class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {        
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        
        if (m == 0 || n == 0) {
            return list;
        }
        
        boolean[][] visited = new boolean[m][n];
        
        int r = 0, c = 0, dirIdx = 0;
        
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        for (int i = 0; i < m * n; i++) {
            list.add(matrix[r][c]);
            visited[r][c] = true;
            
            int nextR = r + dr[dirIdx];
            int nextC = c + dc[dirIdx];
            
            if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || visited[nextR][nextC]) {
                dirIdx = (dirIdx + 1) % 4;
                nextR = r + dr[dirIdx];
                nextC = c + dc[dirIdx];
            }
            
            r = nextR;
            c = nextC;
        }
        
        return list;
    }
}
