import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T, N, M, cnt;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static void binary_search(int k) {
        int L = 1; int R = N; int answer = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] <= k) {
                answer = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        cnt += N - answer;
    }

    static void pro() {
        Arrays.sort(A, 1, N + 1);
        cnt = 0;
        for (int i = 1; i <= M; i++) {
            binary_search(scan.nextInt());
        }
        System.out.println(cnt);
    }


    public static void main(String[] args) throws IOException {
        T = scan.nextInt();
        while(T-- > 0) {
            input();
            pro();
        }
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