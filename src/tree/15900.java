import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, totalDepth;
    static List<Integer>[] adj;
    static int[] dist;

    static void input() {
        N = scan.nextInt();
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N - 1; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = -1;
        }
    }

    static void bfs (int x) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        dist[x] = 0;
        while(!que.isEmpty()) {
            int x1 = que.poll();
            boolean isLeaf = true;
            for (int y : adj[x1]) {
                if (dist[y] != -1) {
                    continue;
                }
                dist[y] = dist[x1] + 1;
                que.add(y);
                isLeaf = false;
            }

            if (isLeaf && x1 != 1) {
                totalDepth += dist[x1];
            }
        }
    }

    static void pro() {
        bfs(1);
        if (totalDepth % 2 == 0) {
            System.out.print("No");
        } else{
            System.out.print("Yes");
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