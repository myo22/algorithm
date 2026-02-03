import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, k;

    static void input() {
        N = scan.nextInt();
        k = scan.nextInt();
    }

    static void binary_search() {
        long L = 1; long R =(long) N * N;
        while(L <= R) {
            long mid = (L + R) / 2;
            if (determination(mid)) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(L);
    }

    static boolean determination (long mid) {
        long count = 0;
        for (int i = 1; i <= N; i++) {
            count += Math.min(mid / i, N);
        }

        return count < k;
    }

    static void pro() {
        binary_search();
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