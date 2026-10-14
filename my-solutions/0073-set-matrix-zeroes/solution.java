class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // 0이 발견된 위치(행, 열)를 저장할 리스트
        List<int[]> zeroCoords = new ArrayList<>();
        
        // 1단계: m x n 배열을 돌며 0인 위치(x, y)를 찾기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroCoords.add(new int[]{i, j});
                }
            }
        }
        
        // 2단계: 저장해 둔 0의 위치를 하나씩 꺼내어 해당 행과 열을 전부 0으로 바꾸기
        for (int[] coord : zeroCoords) {
            int row = coord[0];
            int col = coord[1];
            
            // 해당 행(Row) 전체를 0으로 채우기
            for (int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }
            
            // 해당 열(Column) 전체를 0으로 채우기
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}

