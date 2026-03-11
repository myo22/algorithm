import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int l, T;
    static int[][] dist;
    static int[][] dir = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

    static void input() {
        l = scan.nextInt();
        dist = new int[l][l];

        int x = scan.nextInt();
        int y = scan.nextInt();
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();

        bfs(x, y);
        System.out.println(dist[v1][v2] - 1);
    }


    public static void bfs(int x, int y) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        que.add(y);
        dist[x][y] = 1;
        while(!que.isEmpty()) {
            int x1 = que.poll();
            int y1 = que.poll();
            for (int i = 0; i < 8; i++) {
                int dx = x1 + dir[i][0];
                int dy = y1 + dir[i][1];
                if (dx < 0 || dx >= l || dy < 0 || dy >= l) {
                    continue;
                }
                if (dist[dx][dy] != 0) {
                    continue;
                }
                dist[dx][dy] = dist[x1][y1] + 1;
                que.add(dx);
                que.add(dy);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        T = scan.nextInt();
        while(T-- > 0) {
            input();
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