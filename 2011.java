import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String str;
    static int N;
    static int[] dy;


    static void input() {
        str = scan.next();
        N = str.length();
        dy = new int[N + 1];
    }

    static void pro() {
        if (dy.charAt(0) != "0") {
            dy[0] = 1;
        }

        for (int i = 1; i < N; i++) {
            if (str.charAt(i) != "0") {
                dy[i] = dy[i - 1];
            }

            if(check(str.charAt(i), str.charAt(i - 1))) {
                dy[i] = dy[i - 2];
            } else {
                dy[i] += 1;
            }
        }
    }

    static boolean check(char a, char b) {
        if (a == "1") {

        } else if ( )
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