import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Arrow[] arr;

    static void input() {
        N = scan.nextInt();
        arr = new Arrow[N + 1];
        for (int i = 1; i <= N; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            arr[i] = new Arrow(x, y);
        }
    }

    static class Arrow implements Comparable<Arrow> {
        int coordinate;
        int color;

        public Arrow (int coordinate, int color) {
            this.coordinate = coordinate;
            this.color = color;
        }

        @Override
        public int compareTo(Arrow o) {
            if (this.color != o.color) {
                return this.color - o.color;
            }
            return this.coordinate - o.coordinate;
        }
    }

    static int left (int i) {
        if (i <= 1) {
            return Integer.MAX_VALUE;
        }
        if (arr[i].color != arr[i - 1].color) {
            return Integer.MAX_VALUE;
        }
        return arr[i].coordinate - arr[i - 1].coordinate;
    }

    static int right (int i) {
        if (i >= N) {
            return Integer.MAX_VALUE;
        }
        if (arr[i].color != arr[i + 1].color) {
            return Integer.MAX_VALUE;
        }
        return arr[i + 1].coordinate - arr[i].coordinate;
    }

    static void pro() {
        Arrays.sort(arr, 1, N + 1);
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int a = left(i);
            int b = right(i);
            sum += Math.min(a, b);
        }
        System.out.println(sum);
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