import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] P;
    static Element[] B;

    static void input() {
        N = scan.nextInt();
        B = new Element[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = new Element(scan.nextInt(), i);
        }
    }

    static void pro() {
        Arrays.sort(B);

        for(int i = 0; i < N; i++) {
            P[B[i].idx] = i;
        }
        for(int i = 0; i < N; i++) {
            sb.append(P[i]).append(' ');
        }
        System.out.print(sb.toString());
    }

    static class Element implements Comparable<Element> {
        int value;
        int index;

        public Element (int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Element o) {
            return this.value - o.value;
        }
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