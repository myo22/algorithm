import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T;
    static int[] dp;
    static int mod = 1000000009;

    static void input() {
        T = scan.nextInt();
        dp = new int[100005];
    }

    static void pro() {

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;

        for (int i = 4; i <= 100000; i++) {
            if (i >= 2) dp[i] = (dp[i] + dp[i - 2]) % mod;
            if (i >= 4) dp[i] = (dp[i] + dp[i - 4]) % mod;
            if (i >= 6) dp[i] = (dp[i] + dp[i - 6]) % mod;
        }

        for (int i = 1; i <= T; i++) {
            int n = scan.nextInt();
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb.toString());
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
