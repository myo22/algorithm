import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N, K;
    static long max;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        A = new int[N + 1];
        max = Long.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
            max = Math.max(A[i], max);
        }
    }

    static boolean determination (long n) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += A[i] / n;
        }
        return sum >= K;
    }

    static void binary_search(long start, long end) {
        long answer = 0;
        while(start <= end) {
            long mid = (start + end) / 2;
            if(determination(mid)) {
                start = mid + 1;
                answer = mid;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }


    public static void main(String[] args) throws IOException {
        input();
        binary_search(1, max);
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