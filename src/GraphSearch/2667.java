import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int count = 0;
    static String[] adj;
    static boolean[][] visit;
    static List<Integer> component;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    static void input() {
        N = scan.nextInt();
        adj = new String[N];
        visit = new boolean[N][N];
        component = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj[i] = scan.next();
        }
    }
    
    static void dfs(int row, int col) {
        visit[row][col] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int drow = row + direction[i][0];
            int dcol = col + direction[i][1];

            if(drow < 0 || drow >= N || dcol < 0 || dcol >= N) {
                continue;
            }
            if (visit[drow][dcol]) {
                continue;
            }
            if (adj[drow].charAt(dcol) == '0') {
                continue;
            }
            dfs(drow, dcol);
        }
    }

    static void pro() {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (adj[row].charAt(col) == '1' && !visit[row][col]) {
                    count = 0;
                    dfs(row, col);
                    component.add(count);
                }
            }
        }
        Collections.sort(component);
        sb.append(component.size()).append("\n");
        for (int cnt : component) {
            sb.append(cnt).append("\n");
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