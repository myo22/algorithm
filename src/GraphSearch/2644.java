import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, x1, y1, m;
    static int[] dist;
    static ArrayList<Integer>[] adj;

    static void input() {
        n = scan.nextInt();
        x1 = scan.nextInt();
        y1 = scan.nextInt();
        m = scan.nextInt();
        dist = new int[n + 1];
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <= m; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        dist[start] = 0;
        while(!que.isEmpty()) {
            int x = que.poll();

            for (int y : adj[x]) {
                if (dist[y] != -1) {
                    continue;
                }

                dist[y] = dist[x] + 1;
                que.add(y);
            }
        }
    }

    static void pro() {
        for (int i = 1; i <= n; i++) {
            dist[i] = -1;
        }

        bfs(x1);

        System.out.print(dist[y1]);
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
