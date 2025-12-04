import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        M = scan.nextInt();
    }

    static void pro() {
        Arrays.sort(A, 1, N + 1);
        for (int i = 1; i <= M; i++) {
            int a = scan.nextInt();
            if (binary_search(a)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
    }

    static boolean binary_search(int x) {
        int left = 1, right = N;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == x)
                return true;

            if (A[mid] < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
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