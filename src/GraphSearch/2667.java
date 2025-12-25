import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, cnt;
    static boolean[][] visit;
    static String[] a;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static List<Integer> answer;


    static void input() {
        N = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextLine();
        }
        visit = new boolean[N][N];
    }

    static void dfs (int x, int y) {
        cnt++;
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];
            if (dx < 0 || dy < 0 || dx >= N || dy >= N) {
                continue;
            }
            if (a[dx].charAt(dy) == '0') {
                continue;
            }
            if (visit[dx][dy]) {
                continue;
            }
            dfs(dx, dy);
        }
    }

    static void pro() {
        answer = new ArrayList<>();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (!visit[x][y] && a[x].charAt(y) == '1') {
                    cnt = 0;
                    dfs(x, y);
                    answer.add(cnt);
                }
            }
        }

        Collections.sort(answer);
        sb.append(answer.size()).append("\n");
        for (int cnt : answer) {
            sb.append(cnt).append("\n");
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