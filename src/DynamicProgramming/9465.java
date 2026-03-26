import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T, n;
    static int[][] arr, dp;

    static void input() {
        n = scan.nextInt();
        arr = new int[n + 1][2];
        dp = new int[n + 1][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= n; j++) {
                arr[j][i] = scan.nextInt();
            }
        }
    }

    static void pro() {
        dp[1][0] = 0;
        dp[1][1] = arr[1][0];
        dp[1][2] = arr[1][1];

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + arr[i][0];
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + arr[i][1];
        }

        System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
    }


    public static void main(String[] args) throws IOException {
        T = scan.nextInt();
        while (T-- > 0) {
            input();
            pro();
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