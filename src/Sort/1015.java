import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Elem[] B;
    static int[] P;

    static void input() {
        N = scan.nextInt();
        B = new Elem[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = new Elem(scan.nextInt(), i);
        }
    }

    static class Elem implements Comparable<Elem> {
        public int value;
        public int idx;

        public Elem (int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Elem o) {
            return value - o.value;
        }
    }

    static void pro() {
        Arrays.sort(B);
        for (int i = 0; i < N; i++) {
            P[B[i].idx] = i;
        }

        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(" ");
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