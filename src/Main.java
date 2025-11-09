import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] P;
    static Elem[] B;

    static void input() {
        N = scan.nextInt();
        B = new Elem[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = new Elem();
            B[i].value = scan.nextInt();;
            B[i].index = i;
        }
    }

    static class Elem  implements Comparable<Elem>{
        int value;
        int index;

        @Override
        public int compareTo(Elem o) {
            return this.value - o.value;
        }
    }

    static void pro() {
        Arrays.sort(B);
        for (int i = 0; i < N; i++) {
            P[B[i].index] = i;
        }
        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(" ");
        }
    }

    public static void main(String[] args){
        input();
        pro();

        System.out.println(sb.toString());
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