import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] P, dy;

    static void input() {
        N = scan.nextInt();
        P = new int[N + 1];
        dy = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            P[i] = scan.nextInt();
        }
    }

    static void pro() {
        P[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int cnt = 1; cnt <= i; cnt++) {
                dy[i] = Math.max(dy[i], P[cnt] + dy[i - cnt]);
            }
        }
        System.out.println(dy[N]);
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