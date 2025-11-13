import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static int[][] arr;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            int x = scan.nextInt();
            int y =  scan.nextInt();
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
    }

    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(" ");
        for (int y = 1; y <= N; y++) {
            if (arr[x][y] == 0 || visit[y]) {
                continue;
            }
            dfs(y);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visit[start] = true;
        queue.add(start);
        while(!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(' ');
            for (int y = 1; y <= N; y++) {
                if(arr[x][y] == 0 || visit[y]) {
                    continue;
                }
                queue.add(y);
                visit[y] = true;
            }
        }
    }


    static void pro() {
        visit = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        for (int i = 1; i <= N; i++) {
            visit[i] = false;
        }
        bfs(V);
        System.out.println(sb.toString());
    }


    public static void main(String[] args){
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