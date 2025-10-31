import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, group_cnt;;
    static String[] adj;
    static List<Integer> group;
    static int[][] dir = {{1, 0}, {0, 1}, {-1 , 0}, {0, -1}};
    static boolean[][] visit;

    static void dfs(int x, int y) {
        group_cnt++;
        visit[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || ny >= N | nx >= N) {
                continue;
            }
            if (adj[nx].charAt(ny) == '0') {
                continue;
            }
            if (visit[nx][ny]) {
                continue;
            }
            dfs(nx, ny);
        }
    }

    static void input() {
        N = scan.nextInt();
        adj = new String[N];
        for (int i = 0; i < N; i++) {
            adj[i] = scan.next();
        }
    }

    static void pro() {
        visit = new boolean[N][N];
        group = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i][j] && adj[i].charAt(j) == '1') {
                    group_cnt = 0;
                    dfs(i, j);
                    group.add(group_cnt);
                }
            }
        }
        Collections.sort(group);
        sb.append(group.size()).append("\n");
        for(int a : group) {
            sb.append(a).append("\n");
        }
    }

    public static void main(String[] args){
        input();
        pro();

        System.out.println(sb);
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