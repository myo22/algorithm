import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T, MOD = 1000000009;
    static int dy;

    static void input() {
        T = scan.nextInt();
        dy = new int[100001];
    }

    static void preproceed() {
        dy[0] = 1;
        for (int i = 1; i <= 100000; i++) {
            dy[i] = dy[i - 1];
            if (i - 2 >= 0) {
                dy[i] += dy[i - 2];
                dy[i] %= MOD;
            }
            if (i - 3 >= 0) {
                dy[i] += dy[i - 3];
                dy[i] %= MOD;
            }
        }
    }

    static void pro() {
        preproceed();
        for (int i = 1; i <= T; i++) {
            int x = scan.nextInt();
            for (int mid = 1; mid <= 3; mid++) {

            }
            int res = 0;

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