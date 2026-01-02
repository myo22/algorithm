import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int w, h;
    static boolean[][] visit;
    static int[][] adj;
    static int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}, {-1, -1}, {1, -1}, {1, 1}, {-1, 1}};

    static void input() {
        w = scan.nextInt();
        h = scan.nextInt();
        adj = new int[h + 1][w + 1];
        visit = new boolean[h + 1][w + 1];
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                adj[i][j] = scan.nextInt();
            }
        }
    }

    static void dfs(int y, int x) {
        visit[y][x] = true;
        for (int i = 0; i < 8; i++) {
            int dy = y + direction[i][0];
            int dx = x + direction[i][1];

            if (dx < 1 || dy < 1 || dx > w || dy > h) {
                continue;
            }
            if (visit[dy][dx]) {
                continue;
            }
            if (adj[dy][dx] == 0) {
                continue;
            }
            dfs(dy, dx);
        }
    }

    static void pro() {
        int cnt = 0;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if(!visit[i][j] && adj[i][j] == 1) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }


    public static void main(String[] args) throws IOException {
        while (true) {
            input();
            if (w == 0 && h == 0) break;
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