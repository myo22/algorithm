package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Algorithm_15970 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] arr;

    static void input() {
        N = scan.nextInt();
        arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            int coord = scan.nextInt();
            int color = scan.nextInt();
            arr[color].add(coord);
        }
    }

    static int toLeft(int color, int idx) {
        if (idx == 0) {
            return Integer.MAX_VALUE;
        }
        return arr[color].get(idx) - arr[color].get(idx - 1);
    }

    static int toRight(int color, int idx) {
        if (idx + 1 == arr[color].size()) {
            return Integer.MAX_VALUE;
        }
        return arr[color].get(idx + 1) - arr[color].get(idx);
    }

    static void pro() {
        for (int color = 1; color <= N; color++) {
            Collections.sort(arr[color]);
        }

        int sum = 0;
        for (int color = 1; color <= N; color++) {
            for (int coord = 0; coord < arr[color].size(); coord++) {
                sum += Math.min(toLeft(color, coord), toRight(color, coord));
            }
        }
        System.out.println(sum);
    }


    public static void main(String[] args) {
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
            while (st == null || !st.hasMoreElements()) {
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
