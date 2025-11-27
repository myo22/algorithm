import java.io.IOException;

import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] adj;
    static boolean[] visit;
    static int[] parent;

    static void input() {
        N = scan.nextInt();
        adj = new int[N + 1][N + 1];
        visit = new int[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N - 1; i++) {
            int x = scan.nextInt();
            int y =  scan.nextInt();
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
    }

    static void dfs(int x) {
        visit[x] = true;

        for (int y = 1; y <= N; y++) {
            if (arr[x][y] == 0 || visit[y]) {
                continue;
            }
            parent[y] = x;
            dfs(y);
        }
    }

    static void pro() {
        dfs(1);
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
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