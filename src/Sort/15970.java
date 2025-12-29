import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Coordinate[] coordinate;

    static class Coordinate implements Comparable<Coordinate> {
        int index;
        int color;

        Coordinate (int index, int color) {
            this.index = index;
            this.color = color;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.color != o.color) {
                return Integer.compare(this.color, o.color);
            }
            return Integer.compare(this.index, o.index);
        }
    }

    static void input() {
        N = scan.nextInt();
        coordinate = new Coordinate[N];
        for (int i = 0; i < N; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            coordinate[i] = new Coordinate(x, y);
        }
    }

    static void pro() {
        Arrays.sort(coordinate);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int leftDist = Integer.MAX_VALUE;
            int rightDist = Integer.MAX_VALUE;

            if (i > 0 && coordinate[i].color == coordinate[i - 1].color) {
                leftDist = coordinate[i].index - coordinate[i - 1].index;
            }

            if (i < N - 1 && coordinate[i].color == coordinate[i + 1].color) {
                rightDist = coordinate[i + 1].index - coordinate[i].index;
            }

            sum += Math.min(leftDist, rightDist);
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