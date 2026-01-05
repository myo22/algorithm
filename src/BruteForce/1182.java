import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, S, cnt;
    static int[] P;

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        P = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            P[i] = scan.nextInt();
        }
    }

    static void rec_func(int k, int value) {
        if (N + 1 == k) {
            if (value == S) { 
                cnt++;
            }
        } else {
            rec_func(k + 1, P[k] + value);
            rec_func(k + 1, value);
        }
    }

    static void pro() {
        rec_func(1, P[0]);
        if (S == 0) {
            cnt--;
        }
        System.out.println(cnt);
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