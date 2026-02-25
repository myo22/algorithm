import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, m, count = 0;
    static int[][] adj;
    static boolean[] visit;

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        adj = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        for (int i = 1; i <= m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            adj[a][b] = 1;
            adj[b][a] = 1;
        }
    }

    static void dfs (int x, int depth) {
        if (depth == 2) {
            return;
        }

        for (int y = 1; y <= n; y++) {
            if (adj[x][y] == 1) {
                if(!visit[y]) {
                    visit[y] = true;
                    count++;
                }
                dfs(y, depth + 1);
            }
        }
    }

    static void pro() {
        visit[1] = true;
        dfs(1, 0);
        System.out.println(count);
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