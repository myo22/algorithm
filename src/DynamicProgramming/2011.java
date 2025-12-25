import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String pwd;
    static int[] Dy;
    static int N;

    static void input() {
        pwd = scan.nextLine();
        N = pwd.length();
        Dy = new int[N];
    }

    static boolean check (char A, char B) {
        if (A == '0') {
            return false;
        }
        if (A == '1') {
            return true;
        }
        if (A >= '3') {
            return false;
        }
        return B <= '6';
    }

    static void pro() {
        if (pwd.charAt(0) != '0') {
            Dy[0] = 1;
        }
        for (int i = 1; i < N; i++) {
            if (pwd.charAt(i) != '0') {
                Dy[i] = Dy[i - 1];
            }

            if (check(pwd.charAt(i - 1), pwd.charAt(i))) {
                if (i >= 2) {
                    Dy[i] += Dy[i - 2];
                } else {
                    Dy[i] += 1;
                }
                Dy[i] %= 1000000;
            }
        }
        System.out.println(Dy[N - 1]);
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