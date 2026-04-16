import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, mod = 9901;
    static int[][] dp;

    static void input() {
        N = scan.nextInt();
        dp = new int[N + 1][3];
    }

    static void pro() {
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[2][0] = dp[1][0] + dp[1][1] + dp[1][2];
        dp[2][1] = dp[1][0] + dp[1][2];
        dp[2][2] = dp[1][0] + dp[1][1];

        for (int i = 3; i <= N; i++) {
            dp[i][0] = ((dp[i - 1][0] + dp[i - 1][1]) % mod + dp[i - 1][2]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
        }

        System.out.print(((dp[N][0] + dp[N][1]) % mod + dp[N][2]) % mod);
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
