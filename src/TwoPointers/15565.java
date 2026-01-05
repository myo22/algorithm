import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] P;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        P = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            P[i] = scan.nextInt();
        }
    }

    static void pro() {
        int L = 1, R = 1, cnt = 0, answer = 1000000;
        while(R <= N) {
            if (P[R] == 1) {
                cnt++;
            }
            while(cnt >= K) {
                answer = Math.min(answer, R - L + 1);
                if (P[L] == 1){
                    cnt--;
                }
                L++;
            }
            R++;
        }
        System.out.println(answer == 1000000 ? -1 : answer);
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