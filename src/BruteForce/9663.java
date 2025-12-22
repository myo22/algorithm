import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, cnt;
    static int[] board;

    static void input() {
        N = scan.nextInt();
        board = new int[N + 1];
    }

    static void rec_func(int col) {
        if (col == N + 1) {
            cnt++;
            return;
        } else {
            for (int row = 1; row <= N; row++) {
                if (!canPlace(row, col)) {
                    continue;
                }
                board[col] = row;
                rec_func(col + 1);
            }
        }
    }

    static boolean canPlace(int row, int col) {
        for (int prevCol = 1; prevCol < col; prevCol++) {
            int prevRow = board[prevCol];
            if (prevRow == row) {
                return false;
            }
            if (Math.abs(col - prevCol) == Math.abs(row - prevRow)) {
                return false;
            }
        }
        return true;
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