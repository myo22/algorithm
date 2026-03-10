import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(A, 1, N + 1);
        int L = 1, R = N, sum = Integer.MAX_VALUE, v1 = 0, v2 = 0;

        while(L < R) {
            if (sum > Math.abs(A[L] + A[R])) {
                sum = Math.abs(A[L] + A[R]);
                v1 = A[L];
                v2 = A[R];
            }
            
            if (A[L] + A[R] <= 0) {
                L++;
            } else {
                R--;
            }
        }

        System.out.print(v1 + " " + v2);
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