import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T;
    static int max = Integer.MIN_VALUE;
    static int[] A, dp;
    static int mod = 1000000009;

    static void input() {
        T = scan.nextInt();
        A = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            A[i] = scan.nextInt();
            max = Math.max(A[i], max);
        }
    }

    static void pro() {
        dp = new int[max + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        for (int i = 4; i <= max; i++) {
            if (i - 2 >= 0) {
                dp[i] = (dp[i] + dp[i - 2]) % mod;
            }
            if (i - 4 >= 0) {
                dp[i] = (dp[i] + dp[i - 4]) % mod;
            }
            if (i - 6 >= 0) {
                dp[i] = (dp[i] + dp[i - 6]) % mod;
            }
        }
        for (int i = 1; i <= T; i++) {
            sb.append(dp[A[i]]).append("\n");
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