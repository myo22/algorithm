import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int R, C, wolf, sheep;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] adj;
    static boolean[][] visit;


    static void input() {
        R = scan.nextInt();
        C = scan.nextInt();
        adj = new char[R + 1][C + 1];
        visit = new boolean[R + 1][C + 1];
        for (int row = 1; row <= R; row++) {
            String line = scan.next();
            for (int col = 1; col <= C; col++) {
                adj[row][col] = line.charAt(col - 1);
            }
        }
    } 

    static void dfs (int row, int col) {
        visit[row][col] = true;
        if (adj[row][col] == 'v') {
            wolf++;
        }
        if (adj[row][col] == 'o') {
            sheep++;
        }
        for (int i = 0; i < 4; i++) {
            int drow = row + direction[i][0];
            int dcol = col + direction[i][1];
            if (drow <= 0 || drow > R || dcol <= 0 || dcol > C) {
                continue;
            }
            if (visit[drow][dcol]) {
                continue;
            }
            if (adj[row][col] == '#') {
                continue;
            }
            dfs(drow, dcol);
        }
    }

    static void pro() {
        int answer1 = 0;
        int answer2 = 0;
        for (int row = 1; row <= R; row++) {
            for (int col = 1; col <= C; col++) {
                if ((adj[row][col] =='v' || adj[row][col] == 'o') && !visit[row][col]) {
                    wolf = 0;
                    sheep = 0;
                    dfs(row, col);
                    if (wolf >= sheep) {
                        answer2 += wolf;
                    } else {
                        answer1 += sheep;
                    }
                }
            }
        }
        System.out.println(answer1 + " " + answer2);
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