import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[][] adj, dist;
    static int direction[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String a = scan.nextLine();
            for (int j = 1; j <= M; j++) {
                adj[i][j] = a.charAt(j - 1);
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {x, y});
        dist[x][y] = 1;
        while(!que.isEmpty()) {
            int[] curr = que.poll();
            int x1 = curr[0];
            int y1 = curr[1];
            for (int i = 0; i < 4; i++) {
                int dx = x1 + direction[i][0];
                int dy = y1 + direction[i][1];
                if (dx < 1 || dx > N || dy < 1 || dy > M) {
                    continue;
                }
                if (dist[dx][dy] != 0 || adj[dx][dy] == '0') {
                    continue;
                }
                dist[dx][dy] = dist[x1][y1] + 1;
                que.add(new int[] {dx, dy});
            }
        }
    }

    static void pro() {
        bfs(1, 1);
        System.out.print(dist[N][M]);
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