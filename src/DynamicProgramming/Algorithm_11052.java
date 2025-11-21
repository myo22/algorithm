package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm_11052 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] card, dp;

    static void input() {
        N = scan.nextInt();
        card = new int[N + 1];
        for (int count = 1; count <= N; count++) {
            card[count] = scan.nextInt();
        }
        dp = new int[N + 1];
    }


    static void pro() {
        dp[0] = 0;

        for (int count = 1; count <= N; count++) {
            for (int j = 1; j <= count; j++) {
                dp[count] = Math.max(dp[count], dp[count - j] + card[j]);
            }
        }

        System.out.println(dp[N]);
    }


    public static void main(String[] args){
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