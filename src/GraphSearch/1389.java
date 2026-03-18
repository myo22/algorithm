import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, sum, answer;
    static int[][] adj;
    static int[] dist;
    static int min = Integer.MAX_VALUE;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new int[N + 1][N + 1];
        dist = new int[N + 1];
        for (int i = 1; i <= M; i++) {
            int A = scan.nextInt();
            int B = scan.nextInt();
            adj[A][B] = 1;
            adj[B][A] = 1;
        }
    }

    static void bfs(int x) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        dist[x] = 0;
        while (!que.isEmpty()) {
            int x1 = que.poll();
            for (int y = 1; y <= N; y++) {
                if (adj[x1][y] == 0 || dist[y] != -1) {
                    continue;
                }
                que.add(y);
                dist[y] = dist[x1] + 1;
            }
        }
    }

    static void pro() {
        for (int x = 1; x <= N; x++) {
            sum = 0;
            for (int i = 1; i <= N; i++) {
                dist[i] = -1;
            }
            bfs(x);
            for (int y = 1; y <= N; y++) {
                sum += dist[y];
            }
            if (sum < min) {
                min = sum;
                answer = x;
            }
        }
        System.out.print(answer);
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