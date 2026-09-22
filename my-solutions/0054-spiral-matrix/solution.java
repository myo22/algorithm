class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // 우, 하, 좌, 상 순서의 방향 벡터
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int r = 0, c = 0, dirIdx = 0;

        for (int i = 0; i < rows * cols; i++) {
            res.add(matrix[r][c]);
            visited[r][c] = true;

            // 다음 칸 미리 확인
            int nextR = r + dr[dirIdx];
            int nextC = c + dc[dirIdx];

            // 다음 칸이 범위를 벗어나거나 이미 방문한 곳이라면 방향 전환 (시계 방향 90도)
            if (nextR < 0 || nextR >= rows || nextC < 0 || nextC >= cols || visited[nextR][nextC]) {
                dirIdx = (dirIdx + 1) % 4;
                nextR = r + dr[dirIdx];
                nextC = c + dc[dirIdx];
            }

            // 좌표 이동
            r = nextR;
            c = nextC;
        }

        return res;
    }
}
