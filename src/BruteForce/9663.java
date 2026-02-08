import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, count;
    static int[] col;
    static boolean possible;

    static void input() {
        N = scan.nextInt();
        col = new int[N + 1];
        count = 0;
    }

    static void pro() {
        rec_func(1);
        System.out.println(count);
    }

    static void rec_func(int x) {
        if (x == N + 1) {
            count++;
        } else {
            for (int y = 1; y <=  N; y++) {
                possible = true;
                for (int x1 = 1; x1 < x; x1++) {
                    if(Math.abs(x1 - x) == Math.abs(col[x1] - y) || col[x1] == y) {
                        possible = false;
                    }
                }
                if (possible) {
                    col[x] = y;
                    rec_func(x + 1);
                    col[x] = 0;
                }
            }
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