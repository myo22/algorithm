import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T;
    static long[] dy;
    static int mod = 1000000009;

    static void input() {
        T = scan.nextInt();
        dy = new long[100001];
    }

    static void pro() {
        dy[0] = 1;
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 2;
        for (int i = 4; i <= 100000; i++) {
            if (i - 2 >= 0) {
                dy[i] += dy[i - 2];
            }
            if (i - 4 >= 0) {
                dy[i] += dy[i - 4];
            }
            if (i - 6 >= 0) {
                dy[i] += dy[i - 6];
            }
            dy[i] %= mod;
        }

        for (int i = 1; i <= T; i++) {
            int n = scan.nextInt();
            sb.append(dy[n]).append("\n");
        }
        System.out.println(sb.toString());
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