import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, m, a, b;
    static int result = -1;
    static int[][] adj;
    static boolean[] visit;

    static void input() {
        n = scan.nextInt();
        a = scan.nextInt();
        b = scan.nextInt();
        adj = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        m = scan.nextInt();
        for (int i = 1; i <= m; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }

    static void dfs(int x, int depth) {
        visit[x] = true;
        if (x == b) {
            result = depth;
        } else {
            for (int y = 1; y <= n; y++) {
                if(adj[x][y] == 0 || visit[y]) {
                    continue;
                }
                dfs(y, depth + 1);
            }
        }
    }

    static void pro() {
        dfs(a, 0);
        System.out.println(result);
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