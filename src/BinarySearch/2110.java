import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, C;
    static int[] x;

    static void input() {
        N = scan.nextInt();
        C = scan.nextInt();
        x = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            x[i] = scan.nextInt();
        }
    }

    static void binary_search() {
        int L = 1;
        int R = x[N];
        int answer = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                answer = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(answer);
    }

    static boolean determination(int dist) {
        int count = 1;
        int last = x[1];
        for (int i = 1; i <= N; i++) {
            if (x[i] - last >= dist) {
                count++;
                last = x[i];
            }
        }
        return count >= C;
    }


    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(x);
        binary_search();
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