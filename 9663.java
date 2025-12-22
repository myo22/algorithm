import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, cnt;
    static int[][] board;

    static void input() {
        N = scan.nextInt();
        board = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                board[i][j] = 0;
            }
        }
    }

    static void rec_func(int k) {
        if (k == N) {
            cnt++;
            return;
        } else {
            for (int i = 1; i <= N; i++) {
                if (determination(i, k)) {
                    continue;
                }
                board[i][k] = 1;
                rec_func(k + 1);
                board[i][k] = 0;
            }
        }
    }

    static boolean determination(int row, int col) {
        for (int i = 1; i <= col; i++) {
            for (int j = 1; j <= N; j++) {
                if (board[j][i] == 1) {
                    if (i == col) {
                        return true;
                    }
                    if (Math.abs(col - i) == Math.abs(row - j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static void pro() {
        cnt = 0;
        rec_func(1);
        System.out.println(cnt);
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