import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static int[][] adj;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        adj = new int[N + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }

    static void dfs(int row) {
        visit[row] = true;
        sb.append(row).append(" ");
        for (int col = 1; col <= N; col++) {
            if(adj[row][col] == 0 || visit[col]) {
                continue;
            }
            dfs(col);
        }
    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visit[start] = true;
        while(!que.isEmpty()) {
            int row = que.poll();
            sb.append(row).append(" ");
            for (int col = 1; col <= N; col++) {
                if(adj[row][col] == 0 || visit[col]) {
                    continue;
                }
                visit[col] = true;
                que.add(col);
            }
        }
    }

    static void pro() {
        visit = new boolean[N + 1];
        dfs(V);
        visit = new boolean[N + 1];
        sb.append("\n");
        bfs(V);
        System.out.println(sb.toString());
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