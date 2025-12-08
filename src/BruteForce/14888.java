import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, max, min;
    static int[] A, order;
    static int[] operator;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        operator = new int[5];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        for (int i = 1; i <= 4; i++) {
            operator[i] = scan.nextInt();
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int calculator(int operation1, int operator, int operation2) {
        if (operator == 1) {
            return operation1 + operation2;
        } else if (operator == 2) {
            return operation1 - operation2;
        } else if (operator == 3) {
            return operation1 * operation2;
        } else {
            return operation1 / operation2;
        }
    }

    static void rec_func(int k, int value) {
        if (N == k) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int i = 1; i <= 4; i++) {
                if (operator[i] > 0) {
                    operator[i]--;
                    rec_func(k + 1, calculator(value, i, A[k + 1]));
                    operator[i]++;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        rec_func(1, A[1]);
        sb.append(max).append("\n").append(min);
        System.out.println(sb.toString());
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