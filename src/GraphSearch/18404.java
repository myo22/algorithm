import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, X, Y, A, B;
    static int[][] dist;
    static int[][] direction = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        dist = new int[N + 1][N + 1];
        X = scan.nextInt();
        Y = scan.nextInt();
    }

    static void bfs (int startX, int startY) {
        for (int i = 1; i <= N; i++) Arrays.fill(dist[i], -1);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        dist[startX][startY] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + direction[i][0];
                int ny = y + direction[i][1];

                // 범위 체크 및 방문 여부 확인
                if (nx < 1 || nx > N || ny < 1 || ny > N) {
                    continue;
                }
                if (dist[nx][ny] != -1) {
                    continue;
                }

                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        }
    }

    static void pro() {
        bfs(X, Y);

        for (int i = 1; i <= M; i++) {
            int A = scan.nextInt();
            int B = scan.nextInt();
            sb.append(dist[A][B]).append(" ");
        }

        System.out.print(sb.toString());
    }


    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
