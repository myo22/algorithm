import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] x;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        x = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            x[i] = scan.nextInt();
        }
    }

    static void binary_search() {
        int L = 1, R = N, answer = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                answer = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        System.out.println(answer);
    }

    static boolean determination(int h) {
        int last_reach = 0;
        for (int i = 1; i <= M; i++) {
            if(x[i] - h > last_reach) {
                return false;
            }
            last_reach = x[i] + h;
        }
        return last_reach >= N;
    }


    public static void main(String[] args) throws IOException {
        input();
        binary_search();
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