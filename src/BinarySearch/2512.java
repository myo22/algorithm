import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, max, answer;
    static int[] arr;

    static void input() {
        N = scan.nextInt();
        arr = new int[N + 1];
        max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            arr[i] = scan.nextInt();
            max = Math.max(max, arr[i]);
        }
        M = scan.nextInt();
    }

    static void binary_search(int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (determination(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    static boolean determination(int k) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (arr[i] < k) {
                sum += arr[i];
            } else {
                sum += k;
            }
        }
        return sum <= M;
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