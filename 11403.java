import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static boolean[] visit;
    static List<Integer>[] adj;


    static void input() {
        N = scan.nextInt();
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<Integer>();
            for (int j = 1; j <= N; j++) {
                adj[i].add(j);
            }
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

    static void bfs(int X) {
        Queue<Integer> que = new LinkedList<>();
        que.add(X);
        while(!que.isEmpty()) {
            int x = que.poll();
            for (int y : adj[x]) {
                if(visit[y]) {
                    continue;
                }
                que.add(y);
                visit[y] = true;
            }
        }
        for (int i = 1; i <= N; i++) {
            if(visit[i]) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
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