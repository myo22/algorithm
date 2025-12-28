import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, min, max;
    static int[] Operator, A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        Operator = new int[5];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        for (int i = 1; i <= 4; i++) {
            Operator[i] = scan.nextInt();
        }
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    static int calculator(int a, int b, int k) {
        if (k == 1) {
            return a + b;
        } else if (k == 2) {
            return a - b;
        } else if (k == 3) {
            return a * b;
        } else {
            return a / b;
        }
    }

    static void rec_func(int k, int value) {
        if (k == N) {
            max = Math.max(value, max);
            min = Math.min(value, min);
        } else {
            for (int i = 1; i <= 4; i++) {
                if (Operator[i] > 0) {
                    Operator[i]--;
                    rec_func(k + 1, calculator(value, A[k + 1], i));
                    Operator[i]++;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        rec_func(1, A[1]);

        System.out.println(max);
        System.out.println(min);
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