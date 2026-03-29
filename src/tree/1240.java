import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, x1, y1;
    static int[][] adj;
    static boolean[] visit;
    static boolean found;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new int[N + 1][N + 1];
        for (int i = 1; i <= N - 1; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int dist = scan.nextInt();
            adj[x][y] = dist;
            adj[y][x] = dist;
        }
    }

    static void dfs(int x, int currentSum) {
        if (x == y1) {
            sb.append(currentSum).append("\n");
            found = true;
            return;
        }

        visit[x] = true;
        for (int y = 1; y <= N; y++) {
            if (found) return;
            if (adj[x][y] != 0 && !visit[y]) {
                dfs(y, currentSum + adj[x][y]);
            }
        }
    }

    static void pro() {
        for (int i = 1; i <= M; i++) {
            x1 = scan.nextInt();
            y1 = scan.nextInt();

            visit = new boolean[N + 1];
            found = false;
            
            dfs(x1, 0);
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