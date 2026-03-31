import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, ans;
    static int[] x;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        x = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            x[i] = scan.nextInt();
        }
    }

    static void binary_search(int L, int R) {
        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
    }

    static boolean determination(int H) {
        boolean flag = true;
        if (x[1] - H > 0) return false;

        for (int i = 1; i < M; i++) {
            if (x[i + 1] - x[i] > 2 * H) return false;
        }
        if (x[M] + H < N) return false;
        return flag;
    }

    static void pro() {
        binary_search(1, N);
        System.out.print(ans);
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