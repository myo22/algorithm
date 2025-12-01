package DynamicProgramming;
import java.io.IOException;

import java.io.*;
import java.util.*;

import Main;
import Main.FastReader;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T;
    static long[] dp;
    static int[] A;

    static void input() {
        T = scan.nextInt();
        dp = new long[100001];
        A = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            A[i] = scan.nextInt();
        }
    }

    static void preprocess() {
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        for (int i = 4; i <= 100000; i++) {
            dp[i] = ((i - 2 >= 0 ? dp[i-2] : 0) + (i - 4 >= 0 ? dp[i-4] : 0) + (i - 6 >= 0 ? dp[i-6] : 0)) % 1000000009;
        }
    }

    static void pro() {
        for (int i = 1; i <= T; i++) {
            sb.append(dp[A[i]]).append("\n");
        }
        System.out.println(sb.toString());
    }


    public static void main(String[] args) throws IOException {
        input();
        preprocess();
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