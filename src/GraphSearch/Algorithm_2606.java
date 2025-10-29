package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm_2606 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, count;
    static int[][] A;
    static boolean[] visit;

    static void dfs(int x) {
        visit[x] = true;
        for(int y = 1; y <= N; y++) {
            if (A[x][y] == 0) continue;

            if (visit[y]) {
                continue;
            }
            count++;
            dfs(y);
        }
    }


    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            A[x][y] = A[y][x] = 1;
        }
    }

    public static void main(String[] args){
        input();
        dfs(1);

        System.out.println(count);
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