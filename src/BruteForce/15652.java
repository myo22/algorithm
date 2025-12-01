package BruteForce;
import java.io.IOException;

import java.io.*;
import java.util.*;

import Main;
import Main.FastReader;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A;

    static void rec_func(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(A[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = A[k-1]; i <= N; i++) {
                A[k] = i;
                rec_func(k + 1);
            }
        }
    }

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[M + 1];
    }

    static void pro() {
        A[0] = 1;
        rec_func(1);
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