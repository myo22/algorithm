import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, S;
    static int[] arr;

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = scan.nextInt();
        }
    }

    static void pro() {
        int left = 1, right = 0, sum = 0, min = Integer.MAX_VALUE;

        while (true) {
            if (sum >= S) {
                min = Math.min(min, right - left + 1);
                sum -= arr[left++];
            } else if (right == N) {
                break;
            } else {
                sum += arr[++right];
            }
        }

        if (min == Integer.MAX_VALUE) {
            min = 0;
        }

        System.out.print(min);
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
