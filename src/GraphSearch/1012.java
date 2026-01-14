import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int M, N, K, T;
    static int[][] adj;
    static boolean[][] visit;
    static int[][] direction = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};

    static void input() {
        M = scan.nextInt();
        N = scan.nextInt();
        K = scan.nextInt();
        adj = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 1; i <= K; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[y][x] = 1;
        }
    }

    static void pro() {
        int cnt = 0;
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < M; x++) {
                if(adj[y][x] == 1 && !visit[y][x]) {
                    cnt++;
                    dfs(x, y);
                }
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int x, int y) {
        visit[y][x] = true;
        for(int i = 0; i < 4; i++) {
            int dx = x + direction[i][0];
            int dy = y + direction[i][1];
            if(dx < 0 || dx >= M || dy < 0 || dy >= N) {
                continue;
            }
            if (adj[dy][dx] == 0) { 
                continue;
            }
            if (visit[dy][dx]) {
                continue;
            }
            dfs(dx, dy);
        }
    }


    public static void main(String[] args) throws IOException {
        T = scan.nextInt();
        while (T-- > 0) {
            input();
            pro();
        }
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