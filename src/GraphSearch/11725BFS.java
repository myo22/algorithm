package GraphSearch;
import java.io.IOException;

import java.io.*;
import java.util.*;

import Main;
import Main.FastReader;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static List<Integer>[] adj;
    static int[] Parent;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        adj = new ArrayList[N + 1];
        Parent = new int[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void bfs(int X) {
        Queue<Integer> que = new LinkedList<>();
        que.add(X);
        visit[X] = true;
        while(!que.isEmpty()) {
            int x = que.poll();
            for (int y : adj[x]) {
                if(visit[y]) {
                    continue;
                }
                que.add(y);
                visit[y] = true;
                Parent[y] = x;
            }
        }
    }

    static void pro() {
        bfs(1);
        for (int i = 2; i <= N; i++) {
            sb.append(Parent[i]).append("\n");
        }
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