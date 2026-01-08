import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String N;
    static int len;
    static int[] dp;
    static int mod = 1000000;

    static void input() {
        N = scan.next();
        len = N.length();
        dp = new int[len];
    }

    static void pro() {
        if (N.charAt(0) != '0') {
            dp[0] = 1;
        }

        for (int i = 1; i < len; i++) {
            if(N.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            }

            if (calculate(N.charAt(i - 1), N.charAt(i))) {
                if (i < 2) {
                    dp[i] += 1;
                } else {
                    dp[i] = (dp[i] + dp[i - 2]) % mod;
                }
            }
        }

        System.out.println(dp[len - 1]);
    }

    static boolean calculate (char a, char b) {
        if (a == '0') {
            return false;
        }
        if (a == '1') {
            return true;
        }
        if (a >= '3') {
            return false;
        }
        return b <= '6';
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