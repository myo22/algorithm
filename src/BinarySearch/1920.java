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
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();;
        }
        M = scan.nextInt();
    }

    static void binary_search(int L, int R, int k) {
        int answer = 0;
        while(L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] == k) {
                answer = 1;
                break;
            }
            if (A[mid] < k) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        sb.append(answer).append("\n");
    }

    static void pro() {
        Arrays.sort(A, 1, N + 1);
        for (int i = 1; i <= M; i++) {
            binary_search(1, N, scan.nextInt());
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