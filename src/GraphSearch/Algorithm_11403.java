package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algorithm_11403 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static boolean[] visit;
    static int[][] adj;

    static void input() {
        N = scan.nextInt();
        adj = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                adj[i][j] = scan.nextInt();
            }
        }
    }

    static void bfs(int X) {
        Queue que = new LinkedList<Integer>();
        que.add(X);
        while (!que.isEmpty()) {
            int x = (int) que.poll();
            for (int y = 1; y <= N; y++) {
                if (visit[y] || adj[x][y] == 0) {
                    continue;
                }
                que.add(y);
                visit[y] = true;
            }
        }
        for (int i = 1; i <= N; i++) {
            sb.append(visit[i] ? 1 : 0).append(" ");
        }
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            bfs(i);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }


    public static void main(String[] args) {
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
            while (st == null || !st.hasMoreElements()) {
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