import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int count = 1;
    static int max = Integer.MIN_VALUE;
    static long[] card;

    static void input() {
        N = scan.nextInt();
        card = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            card[i] = scan.nextLong();
        }
    }

    static void pro() {
        Arrays.sort(card, 1, N + 1);
        long answer = card[1];
        for (int i = 1; i <= N - 1; i++) {
            if (card[i] == card[i + 1]) {
                count++;
            } else {
                if (max < count) {
                    answer = card[i];
                    max = count;
                }
                count = 1;
            }
        }

        if (max < count) {
            answer = card[N];
        }
        System.out.println(answer);
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