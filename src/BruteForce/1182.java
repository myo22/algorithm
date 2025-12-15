import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, S, Cnt;
    static int[] A, visit;

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        A = new int[N + 1];
        visit = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static void rec_func(int k, int value) {
        if (k == N + 1) {
            if (S == value) {
                Cnt++;
            }
        } else {
            rec_func(k + 1, value + A[k]);
            rec_func(k + 1, value);
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        rec_func(1, 0);
        if (S == 0) {
            Cnt--;
        }
        System.out.println(Cnt);
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