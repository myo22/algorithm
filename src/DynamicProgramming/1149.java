import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] dp, cost;

    static void input() {
        N = scan.nextInt();
        cost = new int[N + 1][3];
        dp = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            int red = scan.nextInt();
            int green = scan.nextInt();
            int blue = scan.nextInt();
            cost[i][0] = red;
            cost[i][1] = green;
            cost[i][2] = blue;
        }
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (dp[N][i] < min) {
                min = dp[N][i];
            }
        }
        System.out.print(min);
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