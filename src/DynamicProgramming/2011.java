import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String a;
    static long[] dp;

    static void input() {
        a = scan.next();
        dp = new long[a.length() + 1];
    }

    static void pro() {
        if (a.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= a.length(); i++) {
            char now = a.charAt(i - 1);
            if (now != '0') {
                dp[i] += dp[i - 1];
            }
            char prev = a.charAt(i - 2);
            if (prev != '0') {
                int value = (prev - '0') * 10 + (now - '0');
                if (value >= 10 && value <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
            dp[i] %= 1000000;
        }
        System.out.println(dp[a.length()]);
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