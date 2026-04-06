import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] arr;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        arr = new int [N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = scan.nextInt();
        }
    }

    static void pro() {
        int L = 1, R = 1, min = Integer.MAX_VALUE, count = 0;
        while (R <= N) {
            if (arr[R] == 1) {
                count++;
            }

            while (count == K) {
                min = Math.min(min, R - L + 1);

                if (arr[L] == 1) {
                    count--;
                }
                L++;
            }
            R++;
        }

        if (min == Integer.MAX_VALUE) {
            System.out.print("-1");
        } else {
            System.out.print(min);
        }
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
