import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static long answer, max = Long.MIN_VALUE;
    static long[] A;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        A = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextLong();
            max = Math.max(A[i], max);
        }
    }

    static void binary_search(long left, long right) {
        while (left <= right) {
            long mid = (left + right) / 2;
            if (determination(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    static boolean determination(long k) {
        long count = 0;
        for (int i = 1; i <= N; i++) {
            count += A[i] / k;
        }
        return count >= K;
    }

    static void pro() {
        binary_search(1, max);
        System.out.print(answer);
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