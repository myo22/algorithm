package GraphSearch;
import java.io.IOException;

import java.io.*;
import java.util.*;

import Main;
import Main.FastReader;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static List<Integer>[] arr;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        arr = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i <= K; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            arr[x].add(y);
            arr[y].add(x);
        }
    }

    static void bfs (int X) {
        Queue<Integer> que = new LinkedList<>();
        que.add(X);
        visit[X] = true;
        int cnt = 0;
        while (!que.isEmpty()) {
            int x = que.poll();
            for (int y : arr[x]) {
                if (visit[y]) {
                    continue;
                }
                que.add(y);
                visit[y] = true;
                cnt++;
            }
        }
        System.out.println(cnt);
    }


    public static void main(String[] args) throws IOException {
        input();
        bfs(1);
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